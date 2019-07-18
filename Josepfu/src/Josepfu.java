public class Josepfu {
    public static void main(String[] args) {
        //测试一:环形链表
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        //测试小孩出圈是否正确
        circleSingleLinkedList.countBoy(1,2,5);
    }
}

//创建一个Boy 表示节点
class Boy {
    private int no;  //编号

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    private Boy next;//指向下一个节点，默认为null

    public Boy(int no) {
        this.no = no;
    }

}

//创建一个环形的单向链表
class CircleSingleLinkedList {
    //创建一个first节点
    private Boy first = new Boy(-1);

    //添加节点
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        //创建辅助节点,帮助构建环形链表
        Boy curBoy = null;
        //使用for创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环状
                curBoy = first;//让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);//前后节点连接
                boy.setNext(first);//后节点指向头结点
                curBoy = boy;//辅助节点向后移动
            }
        }
    }

    //遍历当前的环形链表
    public void showBoy() {
        //链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        //因为first不能动，因此使用辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号为:" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                System.out.println("已经遍历完毕");
                break;
            } else {
                curBoy = curBoy.getNext();//curBoy后移
            }
        }
    }
    //根据用户的输入，计算出圈顺序

    /**
     * startNo:表示从第几个小孩开始数数
     * countNum:表示数几下
     * nums:表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //辅助指针，帮助完成小孩出圈
        Boy helper = first;
        //1.让helper指向最后一个节点
        while (true) {
            if (helper.getNext() == first) {//helper指向了最后
                break;
            }
            helper = helper.getNext();
        }
        //2.小孩报数前，先让first和helper移动startNo-1次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first和helper指针同时向后移动countNum-1次，然后出圈
        while (true) {
            //圈中只有一个人
            if(helper==first){
                break;
            }
            //first和helper指针同时向后移动countNum-1次.然后出圈
            for(int j=0;j<countNum-1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //这是first指向就是要出圈的节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            //这时将first指向的小孩节点出圈（跳过了一个节点）
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留下小孩%d\n",first.getNo());
    }

}


