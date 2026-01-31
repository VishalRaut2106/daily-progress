class kQueues {

    int[] arr;     
    int[] front;   
    int[] rear;    
    int[] next;    

    int free;      
    int n, k;

    kQueues(int n, int k) {
        this.n = n;
        this.k = k;

        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];

        // initialize all queues as empty
        for (int i = 0; i < k; i++) {
            front[i] = -1;
            rear[i] = -1;
        }

        // initialize free list
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        free = 0;
    }

    void enqueue(int x, int i) {

        if (isFull()) return;

        // take first free index
        int idx = free;
        free = next[idx];

        // if queue empty
        if (front[i] == -1) {
            front[i] = idx;
        } else {
            next[rear[i]] = idx;
        }

        next[idx] = -1;
        rear[i] = idx;

        arr[idx] = x;
    }

    int dequeue(int i) {

        if (isEmpty(i)) return -1;

        int idx = front[i];
        int val = arr[idx];

        // move front
        front[i] = next[idx];

        // if queue becomes empty
        if (front[i] == -1) {
            rear[i] = -1;
        }

        // add idx back to free list
        next[idx] = free;
        free = idx;

        return val;
    }

    boolean isEmpty(int i) {
        return front[i] == -1;
    }

    boolean isFull() {
        return free == -1;
    }
}