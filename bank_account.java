import java.util.*;

public class Main
{
    static MyLinkedList list1=new MyLinkedList();
    static MyLinkedList list2=new MyLinkedList();
    static MyLinkedList list3=new MyLinkedList();

    public static void main (String[] args) throws java.lang.Exception
    {
        fun1_add_list1_user_1();
        fun2_delete_user();
        fun1_add_list1_user_2();
        fun3_pay_user_to_user();
        fun4_get_median_id();
        fun5_merge_account();
        fun6_merge_bank();
    }

    public static void fun1_add_list1_user_1()
    {
        list1.add_user("mark","76000 Verano Road",111,500);
        list1.add_user("may","75000 Verano Road",222,1000);
        list1.add_user("allen","70000 Verano Road",125,200);
        list1.add_user("Howard","77000 Verano Road",114,5000);

        System.out.println("fun1_add_list1_user_1");
        for(int i=0;i<list1.size;i++)   System.out.println(list1.get(i).id+" "+list1.get(i).name+" "+list1.get(i).address+" "+list1.get(i).ssn+" "+list1.get(i).deposit_amount);
        System.out.println();
    }

    public static void fun1_add_list1_user_2()
    {
        list1.add_user("max","71000 Verano Road",255,1500);
        list1.add_user("may","75000 Verano Road",222,1000);
        list1.add_user("rocky","79000 Verano Road",228,1200);

        System.out.println("fun1_add_list1_user_2 : 3 people");
        for(int i=0;i<list1.size;i++)   System.out.println(list1.get(i).id+" "+list1.get(i).name+" "+list1.get(i).address+" "+list1.get(i).ssn+" "+list1.get(i).deposit_amount);
        System.out.println();
    }

    public static void fun1_add_list2_user_1()
    {
        list2.add_user("Jerry","73300 Verano Road",112,50);
        list2.add_user("alex","71200 Verano Road",113,10);
        list2.add_user("Queen","70100 Verano Road",114,60);

        System.out.println("fun1_add_list2_user_1");
        for(int i=0;i<list2.size;i++)   System.out.println(list2.get(i).id+" "+list2.get(i).name+" "+list2.get(i).address+" "+list2.get(i).ssn+" "+list2.get(i).deposit_amount);
        System.out.println();
    }

    public static void fun2_delete_user()
    {
        list1.delete_user(0);
        list1.delete_user(2);

        System.out.println("delete_user_0 & 2");
        for(int i=0;i<list1.size;i++)   System.out.println(list1.get(i).id+" "+list1.get(i).name+" "+list1.get(i).address+" "+list1.get(i).ssn+" "+list1.get(i).deposit_amount);
        System.out.println();
    }

    public static void fun3_pay_user_to_user()
    {
        list1.pay_user_to_user(0,3,100);

        System.out.println("pay_user_to_user : 0 give 3, 100 dollars");
        for(int i=0;i<list1.size;i++)   System.out.println(list1.get(i).id+" "+list1.get(i).name+" "+list1.get(i).address+" "+list1.get(i).ssn+" "+list1.get(i).deposit_amount);
        System.out.println();
    }

    public static void fun4_get_median_id()
    {
        System.out.println("get_list1_median_id");
        System.out.println(list1.get_median_id());
        System.out.println();
    }

    public static void fun5_merge_account()
    {
        System.out.println("merge 1 & 2 : may");
        int error=list1.merge_account(1,2);

        if(error==0)
        {
            for(int i=0;i<list1.size;i++)   System.out.println(list1.get(i).id+" "+list1.get(i).name+" "+list1.get(i).address+" "+list1.get(i).ssn+" "+list1.get(i).deposit_amount);
            System.out.println();
        }
        else if(error==1)
        {
            System.out.println("NaN");
            System.out.println();
        }
    }

    public static void fun6_merge_bank()
    {
        list2.add_user("Jerry","73300 Verano Road",112,50);
        list2.add_user("alex","71200 Verano Road",113,10);
        list2.add_user("Queen","70100 Verano Road",114,60);

        System.out.println("fun1_add_list2_user_1");
        for(int i=0;i<list2.size;i++)   System.out.println(list2.get(i).id+" "+list2.get(i).name+" "+list2.get(i).address+" "+list2.get(i).ssn+" "+list2.get(i).deposit_amount);
        System.out.println();

        list3=list1.merge_bank(list1,list2,list3);

        System.out.println("merge bank 1 & 2");

        for(int i=0;i<list3.size;i++)   System.out.println(list3.get(i).id+" "+list3.get(i).name+" "+list3.get(i).address+" "+list3.get(i).ssn+" "+list3.get(i).deposit_amount);
        System.out.println();
    }
}

class MyLinkedList
{
    //size???????????????????????????
    int size;
    //???????????????
    ListNode head;												//???????????????head?????????????????????ex. 1->2->4??????head??????	head->1->2->4
    //****??????head???????????????size??????3
    Queue<Integer> queue=new LinkedList<>();
    int error=0;
    //???????????????
    public MyLinkedList()
    {
        size = 0;
        head = new ListNode("","",0,0,0);
    }

    public MyLinkedList merge_bank(MyLinkedList list1,MyLinkedList list2,MyLinkedList list3)
    {
        list3=list1;
        int cur=-1;
        if(!queue.isEmpty())    cur=queue.poll();

        for(int i=0;i<list2.size;i++)
        {
            if(list2.get(i).id!=cur)
            {
                list3.addAtIndex(list3.size, list2.get(i).name,list2.get(i).address, list2.get(i).ssn,list2.get(i).deposit_amount,list3.get(size-1).id+1);
            }
            else if(list2.get(i).id==cur)
            {
                list3.addAtIndex(list2.get(i).id, list2.get(i).name,list2.get(i).address, list2.get(i).ssn,list2.get(i).deposit_amount,list2.get(i).id);

                if(!queue.isEmpty())    cur=queue.poll();
            }
        }

        return list3;
    }

    public int merge_account(int id1,int id2)
    {
        ListNode Node1=get(id1);
        ListNode Node2=get(id2);

        if((Node1.name.equals(Node2.name))&&(Node1.address.equals(Node2.address))&&(Node1.ssn==Node2.ssn))
        {
            if(id1<=id2)
            {
                Node1.deposit_amount=Node1.deposit_amount+Node2.deposit_amount;
                delete_user(id2);
            }
            else
            {
                Node2.deposit_amount=Node2.deposit_amount+Node1.deposit_amount;
                delete_user(id1);
            }
        }
        else
        {
            error=1;
        }
        return error;
    }

    public int get_median_id()
    {
        if(size%2==0)       return get(size/2-1).id;
        else                return get(size/2).id;
    }

    public void pay_user_to_user(int id1,int id2,int amount)
    {
        ListNode Node1=get(id1);
        ListNode Node2=get(id2);

        Node1.deposit_amount=Node1.deposit_amount-amount;
        Node2.deposit_amount=Node2.deposit_amount+amount;
    }
    //?????????index????????????ListNode
    public ListNode get(int index)
    {
        //??????index???????????????-1
        if (index < 0 || index >= size) 						//ex. 	1->2->4?????????size???3?????????index???
        {														//index 0, 1, 2
            return null;
        }
        ListNode currentNode = head;
        //????????????????????????????????????????????? index+1 ?????????
        for (int i = 0; i < index + 1; i++) 					//ex. 	1->2->4??????head??????	head->1->2->4	//?????????for (int i = 0; i < index; i++)????????????index?????????????????????
        {														//index 0, 1, 2			index  0, 1, 2, 3	//??????for (int i = 0; i < index + 1; i++)????????????index
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    //????????????index????????????????????????
    public void add_user(String name,String address, int ssn,int deposit_amount)
    {
        int id;
        if(!queue.isEmpty())    id=queue.poll();
        else                    id=size;
        addAtIndex(id, name,address,ssn,deposit_amount,id);
    }

    // ?????? index ?????????????????????????????????????????????index???0??????????????????????????????????????????????????????
    // ?????? index ???????????????????????????????????????????????????????????????????????????
    // ?????? index ????????????????????????????????????
    public void addAtIndex(int index, String name,String address, int ssn,int deposit_amount,int id)
    {
        if (index > size)
        {
            return;
        }
        if (index < 0)
        {
            index = 0;
        }

        //??????????????????????????????
        ListNode pred = head;
        for (int i = 0; i < index; i++) 			//??????index??????1?????????
        {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(name,address,ssn,deposit_amount,id);
        toAdd.next = pred.next;
        pred.next = toAdd;

        size++;
    }

    //?????????index?????????
    public void delete_user(int id)
    {
        ListNode pred = head;
        ListNode cur=head.next;
        for (int i = 0; i < size-1; i++) 			//??????index??????1?????????
        {
            if(cur.id!=id)
            {
                pred=pred.next;
                cur = cur.next;
            }
        }
        queue.add(pred.next.id);
        pred.next = pred.next.next;

        size--;
    }
}


class ListNode
{
    int id,ssn,deposit_amount;
    String name,address;
    ListNode next;
    ListNode(){}				//constructor?????????
    ListNode(String name,String address, int ssn,int deposit_amount,int id) 			//constructor?????????
    {
        this.name=name;
        this.address=address;
        this.ssn=ssn;
        this.deposit_amount=deposit_amount;
        this.id=id;
    }
}