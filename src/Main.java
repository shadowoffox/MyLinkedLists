import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        MyDoubleLinkedList<String> mll = new MyDoubleLinkedList<>();


        mll.insertFirst("den");
        mll.insertFirst("suka");
        mll.insertFirst("pen");
        mll.insertFirst("deck");
        mll.insertFirst("dick");

        System.out.println(mll.getFirst());
        System.out.println(mll.removeFirst());
        System.out.println(mll);
        System.out.println(mll.removee("pen"));
        System.out.println(mll);
        mll.insert(2,"super");

        System.out.println(mll);
        mll.insertLast("muha");
        System.out.println(mll);
        System.out.println(mll.removee("suka"));
        System.out.println(mll);
        mll.insert(1,"shobla");
        System.out.println(mll);

        Iterator<String> iterator = mll.iterator();
       while (iterator.hasNext()){
            System.out.print(iterator.next()+ ", ");

        }
       /* for (String s: mll) {
            System.out.print(s + "");
        }*/


    }

}
