import java.util.Iterator;

public class MyDoubleLinkedList<Item> implements Iterable<Item>{

private Dot first;
private Dot last;
private int size = 0;

    public MyDoubleLinkedList() {
        this.first = null;
        this.last = null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<Item> {
        Dot current = new Dot(null,first);

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public Item next() {
            current = current.getNext();
            return (Item) current.getValue();
        }

    }


    private class Dot<Item> {
        private Item value;
        private Dot next;
        private Dot previous;

        public Dot(Item value, Dot next) {
            this.value = value;
            this.next = next;
        }

        public void setPrevious(Dot previous) {
            this.previous = previous;
        }

        public Dot getPrevious() {
            return previous;
        }

        public Dot(Item value) {
            this.value = value;
        }


        public void setValue(Item value) {
            this.value = value;
        }

        public void setNext(Dot next) {
            this.next = next;
        }

        public Item getValue() {
            return value;
        }

        public Dot getNext() {
            return next;
        }
        @Override
        public String toString() {
            return value.toString();
        }
    }

    public boolean isEmpty(){
        return first== null;
    }

    public int size(){
        return size;
    }

    public Item getFirst() {
        return (Item) first.value;
    }

    public Item getLast() {return (Item) last.value;  }

    public void insertFirst(Item item){
        Dot newDot = new Dot(item);
        newDot.setNext(first);
        if (!isEmpty()){
            first.setPrevious(newDot);
        } else {
            last = newDot;
        }
        first=newDot;
        size++;
    }

    public Item removeFirst(){
        if (isEmpty()) return null;
        Dot oldFirst = first;
        first = first.getNext();
        if (isEmpty()){
            last = null;
        } else {
           first.setPrevious(null);
        }
        size--;
        return (Item) oldFirst.getValue();
    }

    public void insertLast(Item item){
        Dot newDot = new Dot(item);
        if (!isEmpty()){
            newDot.setPrevious(last);
            last.setNext(newDot);
        } else {
            first = newDot;
        }
        last=newDot;
        size++;
    }

    public Item removeLast(){
        if (isEmpty()) return null;
        Dot oldLast = first;
        if (last.getPrevious()!=null){
            last.getPrevious().setNext(null);
        } else {
            first=null;
        }
        last= last.getPrevious();
        size--;
        return (Item) oldLast.getValue();
    }

    public int indexOf(Item item){
    Dot current = first;
    int index = 0;

    while (current != null){
        if (item.equals(current.getValue())){
            return index;
        }
        current =current.getNext();
        index++;
    }
        return -1;
    }

    public boolean isContain(Item item){
        return indexOf(item)>= -1;

    }

    public void insert(int index, Item item){
        if (index<=0){
            insertFirst(item);
        }
        if (index>size){
            insertLast(item);
        }
        Dot current = first;
        int i=0;

        while (i<index-1){
            current=current.getNext();
            i++;
        }
        Dot newDot = new Dot(item);

        newDot.setNext(current.getNext());
        newDot.setPrevious(current);
        newDot.getNext().setPrevious(newDot);
        current.setNext(newDot);
        size++;
    }

    public boolean removee(Item item){
        if (isEmpty()) return false;

         if (first.getValue().equals(item)){
             removeFirst();
             return true;
         }

        Dot current = first;
         while (current !=null && !current.getValue().equals(item)){
            current = current.getNext();
         }
         if (current.getNext() == null) return false;
         if (current == last){
             removeLast();
             return true;
         }
         current.getPrevious().setNext(current.getNext());
         current.getNext().setPrevious(current.getPrevious());
         size--;
         return true;
    }

    @Override
    public String toString() {
        Dot current = first;

        StringBuilder sb = new StringBuilder();
        while (current !=null){
            sb.append(current.getValue()+ " ");
            current = current.getNext();

        }
        return sb.toString();
    }
}
