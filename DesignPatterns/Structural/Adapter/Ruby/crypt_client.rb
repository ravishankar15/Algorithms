class Encrypter
  def initialize(key)
    @key = key
  end

  def encrypt(reader, writer)
    key_index = 0
    until reader.eof?
      encrypter_char = reader.getbyte ^ @key.getbyte(key_index)
      writer.putc(encrypter_char)
      key_index = (key_index + 1) % @key.size
    end
  end
end

class StringIOAdapter
  def initialize(string)
    @string  = string
    @position = 0
  end

  def eof?
    @position >= @string.length
  end

  def getbyte
    raise EOFError if eof?

    ch = @string.getbyte(@position)
    @position += 1
    ch
  end
end

class Decrypter
  def initialize(key)
    @key = key
  end

  def decrypt(reader)
    decrypted_message = ''
    key_index = 0
    until reader.eof?
      encrypted_byte = reader.getbyte
      key_byte = @key.getbyte(key_index)
      decrypted_byte = (encrypted_byte ^ key_byte)
      decrypted_message << decrypted_byte.chr('UTF-8')
      key_index = (key_index + 1) % @key.size
    end
    puts decrypted_message
  end
end



reader = File.open('message.txt')
writer = File.open('message.encrypted', 'w')
encrypter = Encrypter.new('XYZZY')
encrypter.encrypt(reader, writer)
reader.close
writer.close


reader = StringIOAdapter.new('We attack at dawn')
writer = File.open('out.txt', 'w')
encrypter = Encrypter.new('XYZZY')
encrypter.encrypt(reader, writer)
writer.close

reader = File.open('message.encrypted')
decrypter = Decrypter.new('XYZZY')
decrypter.decrypt(reader)
reader.close

reader = File.open('out.txt')
decrypter = Decrypter.new('XYZZY')
decrypter.decrypt(reader)
reader.close