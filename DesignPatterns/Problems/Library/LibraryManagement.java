//Enums and constants: Here are the required enums, data_types and constants

enum BookFormat {
  HARDCOVER, PAPERBACK, AUDIO_BOOK, EBOOK, NEWSPAPER, MAGAZINE, JOURNEL
}

enum BookStatus {
  AVAILABLE, RESERVED, LOANED, LOST
}

enum ReservationStatus {
  WAITING, PENDING, CANCELED, COMPLETED, NONE
}

enum AccountStatus {
  ACTIVE, CLOSED, CANCELED, BLACKLISTED, NONE
}

class Address {
  private String streetAddress;
  private String city;
  private String state;
  private String zipCode;
  private String country;
}

class Person {
  private String name;
  private Address address;
  private String email;
  private String phone;
}

class Constants {
  public static final int MAX_BOOKS_ISSUED_TO_A_USER = 5;
  public static final int MAX_LENDING_DAYS = 10;
}

//Account, Member and Librarian These classes represent the various people that intract with our system
abstract class Account {
  private String id;
  private String password;
  private AccountStatus status;
  private Person person;

  public boolean resetPassword();
}

class Librarian extends Account {
  public boolean addBookItem(BookItem bookItem);
  public boolean blockMember(Member member);
  public boolean unBlockMember(Member member);
}

class Member extends Account {
  private Date dateOfMembership;
  private int totalBooksCheckedOut;
  public int getTotalBookCheckedOut();
  public boolean reserveBookItem(BookItem bookItem);
  private void incrimentTotalBooksCheckedOut();
  private void decrementTotalBooksCheckedOut();

  // public boolean checkoutBookItem(BookItem bookItem);
  // public boolean returnBookItem(BookItem bookItem);
  // public boolean renewBookItem(BookItem bookItem);

  public boolean checkoutBookItem(BookItem bookItem) {
    if(this.getTotalBookCheckedOut() >= Constants.MAX_BOOKS_ISSUED_TO_A_USER) {
      showError("The user has already checkedout maximum number of books");
      return false;
    }
    BookReservations bookReservations = BookReservations.fetchReservationDetails(bookItem.getBarCode());
    if(bookReservations != null && bookReservations.getMemberId() != this.getId()){
      //Book item has a pending reservation from another user
      showError("This book is reserved by another member");
      return false
    } else if(bookReservations != null) {
      //Book item has a pending reservation from the given member, update it
      bookReservations.updateStatus(ReservationStatus.COMPLETED)
    }

    if(!bookItem.checkout(this.getId())){
      return false;
    }

    this.incrimentTotalBooksCheckedOut();
    return true;
  }

  public void returnBookItem(BookItem bookItem) {
    this.checkFine();
    BookReservations bookReservations = BookReservations.fetchReservationDetails(bookItem.getBarCode());
    if(bookReservations != null) {
      //book item has a pending reservation
      bookItem.updateBookItemStatus(BookStatus.RESERVED);
      bookReservations.sendBookAvailableNotification();
    }
    bookItem.updateBookItemStatus(BookStatus.AVAILABLE);
  }

  public boolean renewBookItem(BookItem bookItem) {
    this.checkFine();
    BookReservations bookReservations = BookReservations.fetchReservationDetails(bookItem.getBarCode());
    if(bookReservations != null && bookReservations.getMemberId() != this.getId()){
      //book item has a pending reservation from another member
      showError("This book is reserver by anothe member");
      this.decrementTotalBooksCheckedOut();
      bookItem.updateBookItemStatus(BookStatus.RESERVED);
      bookReservations.sendBookAvailableNotification();
      return false;
    } else if(bookReservations != null) {
      // book item has a pending reservation from this member
      bookReservations.updateStatus(ReservationStatus.COMPLETED);
    }
    BookLending.lendBook(bookItem.getBarCode(), this.getId());
    bookItem.updateDueDate(LocalDate.now().plusDays(Constants.MAX_LENDING_DAYS));
    return true;
  }

  // Private Methods
  private void checkFine(String bookItemBarcode) {
    BookLending bookLending = BookLending.fetchLendingDetails(bookItemBarcode);
    Date dueDate = bookLending.getDueDate();
    Date today = new Date();

    if(today.compareTo(dueDate) > 0) {
      long diff = todayDate.getTime() - dueDate.getTime();
      long diffDays = diff / (24 * 60 * 60 * 1000)
      Fine.collectFine(this.getId(), diffDays)
    }
  }
}

//BookingReservation, BookLending and Fine These classes represent the book reservation, lending and fine respectively
class BookReservation {
  private Date creationDate;
  private ReservationStatus status;
  private String  bookItemBarCode;
  private String memberId;

  public static BookReservation  fetchReservationDetails(String barCode);
}

class BookLending {
  private Date creationDate;
  private Date dueDate;
  private Date returnDate;
  private String bookItemBarcode;
  private String memberId;

  public static void lendBook(String barcode, String memberId);
  public static BookLending fetchLendingDetails(String barcode);
}

class Fine {
  private Date creationDate;
  private double bookItemBarcode;
  private String memberId;
}

//BookItem: Encapsulating a book item, this class will be responsible for precessing the reservation, return and renewal of a book item.
abstract class Book {
  private String ISBN;
  private String title;
  private String subject;
  private String publisher;
  private String language;
  private int numberOfPages;
  private List<Author> authors;
}

class BookItem extends Book {
  private String barcode;
  private boolean isReferenceOnly;
  private Date borrowed;
  private Date dueDate;
  private double price;
  private BookFormat format;
  private BookStatus status;
  private Date dateOfPurchase;
  private Date publicationDate;
  private Rack placedAt;

  public boolean checkout(String memberId) {
    if(bookItem.getIsReferenceOnly()) {
      ShowError("This book is Reference only and can't be issued");
      return false;
    }
    if(!BookLending.lendBook(this.getBarCode(), memberId)){
      return false;
    }
    this.updateBookItemStatus(BookStatus.LOANED);
    return true;
  }
}

class Rack {
  private int number;
  private String locationIdentifier;
}

//Search interface catalog: The Catalog class will implement the Search interface to facilitate searching of books.
interface Search {
  public List<Book> searchByTitle(String title);
  public List<Book> searchByAuthor(String author);
  public List<Book> searchBySubject(String subject);
  public List<Book> searchByPubDate(Date publishDate);
}

class Catalog implements Search {
  private HashMap<String, List<Book>> bookTitles;
  private HashMap<String, List<Book>> bookAuthors;
  private HashMap<String, List<Book>> bookSubjects;
  private HashMap<String, List<Book>> bookPublicationDates;

  public List<Book> searchByTitle(String query) {
    // return all books containing the string query in their title.
    return bookTitles.get(query);
  }

  public List<Book> searchByAuthor(String query) {
    // return all books containing the string query in their author's name.
    return bookAuthors.get(query);
  }
}