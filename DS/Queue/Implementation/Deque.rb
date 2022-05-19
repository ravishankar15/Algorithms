class Deque
    attr_accessor :size, :cqarr, :front, :rear

    def initialize(size)
        @size = size
        @front = -1 
        @rear = -1
        @cqarr = Array.new(@size)
    end

    def is_full?()
        (@front == 0 && @rear == size - 1) || (@rear == @front - 1)
    end

    def is_empty?()
        @front == -1
    end

    def enqueue(data)
        raise 'Queue is full' if is_full?

        if @front == -1
            @front = 0
            @rear = 0
        elsif @rear == @size-1
            @rear = 0
        else
            @rear += 1
        end

        @cqarr[@rear] = data
    end

    def enqueueFront(data)
        raise 'Queue is full' if is_full?

        if @front == -1
            @front = 0
            @rear = 0
        elsif @front == 0
            @front = @size - 1
        else
            @front -= 1
        end
        @cqarr[@front] = data
    end

    def dequeueLast()
        raise 'Queue is empty' if is_empty?

        data = @cqarr[@rear]
        if @front == @rear
            @front = -1
            @rear = -1
        elsif @rear == 0
            @rear = @size - 1
        else
            @rear -= 1
        end
        data
    end

    def dequeue()
        raise 'Queue is empty' if is_empty?

        data = @cqarr[@front]
        if @front == @rear
            @front = -1
            @rear = -1
        elsif @front == @size - 1
            @front = 0
        else
            @front += 1
        end
        data
    end

    def peek()
        @cqarr[@front]
    end

    def peekLast()
        @cqarr[@rear]
    end
end