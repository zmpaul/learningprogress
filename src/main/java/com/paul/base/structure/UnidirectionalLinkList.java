package com.paul.base.structure;

/**
 * 简单实现单向链表，插入快，查询慢，每次从头开始遍历
 * 实现新增Last节点、新增Head节点,获取头节点，获取Last节点，
 * 删除节点、插入指定位置节点
 * 
 * @ClassName: 利用单向链表可以实现栈（入head出head），队列(入head出Last)
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年4月12日 下午3:01:14
 * @param <E>
 */
public class UnidirectionalLinkList<E> {

    public class Node<T> {

        // 指针域
        private Node next;
        // 数据内容
        private T t;

        public Node(T t) {
            this.t = t;
        }

        public String toString() {
            return t.toString();
        }
    }

    // 定义头节点
    private Node head;
    // 定义节点长度
    private int length;

    // 增加节点
    public void addLastNode(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        // 一直取最后一个元素null
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addHeadNode(Node node) {
        Node temp = head;
        head = node;
        node.next = temp;
    }

    /**
     * 取头节点
     * @Title: getHeadNode
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author admin
     * @return
     * @throws
     */
    public Node getHeadNode() {
        Node temp = head;
        return temp;
    }

    public Node getLastNode() {
        Node temp = getHeadNode();
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    // 计算链表有效长度
    public int length(){
        Node temp = getHeadNode();
        if (temp == null) {
            return length;
        }
        length++;
        // 一直取最后一个元素null
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 指定索引插入节点信息
     * @Title: insertNodeByIndex
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author admin
     * @param index
     * @param node
     * @throws
     */
    public void insertNodeByIndex(int index, Node node) {
        int maxIndex = length();
        int _index = 0;
        // 越界
        if (index > maxIndex) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = getHeadNode();
        // 插入链表头
        if (index == 0) {
            addHeadNode(node);
        }
        // 插入链表尾
        else if (index == maxIndex) {
            addLastNode(node);
        }
        else {
            while (temp.next != null) {
                if (index == ++_index) {
                    // curNode next -> node ; node next ->curNode.next
                    Node next = temp.next;
                    temp.next = node;
                    node.next = next;
                    break;
                };
                temp = temp.next;
            }
        }
    }

    /**
     * 删除指定节点
     * @Title: deleteNode
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author admin
     * @param node
     * @throws
     */
    public void deleteNode(Node node) {
        Node temp = getHeadNode();
        // 删除节点是头节点，直接把头结点指向删除节点的下一节点
        if (temp == node) {
            if (temp.next != null) {
                head = temp.next;
            }
            return;
        }
        
        while (temp.next != null) {
            if (temp.next == node) {
                if (node.next != null) {
                    temp.next = node.next;
                }
                else {
                    temp.next = null;
                }
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 遍历节点所有信息
     * @Title: iterator
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author admin
     * @return
     * @throws
     */
    public String iterator() {
        if (head == null) {
            return "空链表";
        }
        StringBuilder sBuilder = new StringBuilder();
        Node temp = getHeadNode();
        sBuilder.append(temp.t + "(head)--->");
        while (temp.next != null) {
            temp = temp.next;
            sBuilder.append("" + temp.t + "--->");
        }
        return sBuilder.toString();
    }

    public static void main(String[] args) {
        UnidirectionalLinkList aLinkList = new UnidirectionalLinkList();
        UnidirectionalLinkList.Node a = aLinkList.new Node(1);
        aLinkList.addLastNode(a);
        // 不能多次指向同一内存地址引起死循环导致内存溢出
        // aLinkList.addNode(a);
        UnidirectionalLinkList.Node a2 = aLinkList.new Node("2");
        aLinkList.addLastNode(a2);
        UnidirectionalLinkList.Node a3 = aLinkList.new Node(null);
        aLinkList.addLastNode(a3);
        UnidirectionalLinkList.Node a4 = aLinkList.new Node("4");
        
        //aLinkList.addNode(a3);
        //aLinkList.deleteNode(a);
        
        aLinkList.insertNodeByIndex(3, a4);
        System.out.println(aLinkList.iterator());
        System.out.println(aLinkList.getHeadNode());
        System.out.println(aLinkList.getLastNode());
    }
}





