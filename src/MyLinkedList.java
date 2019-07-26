import java.util.Iterator;

public class MyLinkedList<Item>{

private Dot first;
private int size = 0;

    public MyLinkedList() {
        this.first = null;
    }





   private class Dot<Item> {
        private Item value;
        private Dot next;

        public Dot(Item value) {
            this.value = value;
        }

       public Dot(Item value, Dot next) {
           this.value = value;
           this.next = next;
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

    public void insertFirst(Item item){
        Dot newDot = new Dot(item);
        newDot.setNext(first);
        first=newDot;
        size++;
    }

    public Item removeFirst(){
        if (isEmpty()) return null;

        Dot oldFirst = first;
        first = first.getNext();
        size--;
        return (Item) oldFirst.getValue();
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

        Dot current = first;
        int i=0;
        if (index>size){
            index=size;
        }

        while (i<index-1){
            current=current.getNext();
            i++;
        }
        Dot newDot = new Dot(item);
        newDot.setNext(current.getNext());
        current.setNext(newDot);
        size++;
    }

    public boolean remove(Item item){
        if (isEmpty()) return false;

         if (first.getValue().equals(item)){
             removeFirst();
             return true;
         }
        Dot current = first;
         while (current.getNext()!=null && !current.getNext().getValue().equals(item)){
            current = current.getNext();
         }
         if (current.getNext() == null) return false;
         current.setNext(current.getNext().getNext());
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
