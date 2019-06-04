package com.paul.base.structure;

/**
 * 简单实现双向(非循环)链表，
 * 实现新增Last节点、新增Head节点,获取头节点，获取Last节点，
 * 删除节点、插入指定位置节点
 * 
 * @ClassName: DoubleDirectionLink
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年4月12日 下午5:20:18
 */
public class DoubleDirectionLink {
    public class Node<T> {

        // 指针域
        private Node next;
        // 上一个指针
        private Node prevNode;
        // 数据内容
        private T t;

        // 数据填充
        public Node(T t) {
            this.t = t;
        }

        public String toString() {
            // 输出t
            return t.toString();
        }
    }

    // 头节点
    private Node head;

    public Node getHeadNode() {
        return head;
    }

    public String iterator() {
        if (head == null) {
            return "空链表";
        }
        StringBuilder sBuilder = new StringBuilder();
        Node temp = getHeadNode();
        sBuilder.append(
                temp.t + "(head)[prevNode:" + (temp.prevNode != null ? temp.prevNode.t : "null")
                        + ",nextNode:" + (temp.next != null ? temp.next.t : "null") + "]" + "<---->");
        while (temp.next != null) {
            temp = temp.next;
            sBuilder.append(temp.t + "[prevNode:"
                    + (temp.prevNode != null ? temp.prevNode.t : "null") + ",nextNode:"
                    + (temp.next != null ? temp.next.t : "null") + "]" + "<---->");
            // 首尾相连
            if (temp.next == head.prevNode) {
                break;
            }
        }
        return sBuilder.toString();
    }

    /**
     * 插入尾节点
     * @Title: addLastNode
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author admin
     * @param node
     * @throws
     */
    public void addLastNode(Node node) {
        Node _head = getHeadNode();
        if (_head == null) {
            head = node;
            return;
        }
        while (_head.next != null) {
            _head = _head.next;
        }

        _head.next = node;
        node.prevNode = _head;
    }

    /**
     * 插入头节点
     * @Title: addHeadNode
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author admin
     * @param node
     * @throws
     */
    protected void addHeadNode(Node node) {
        Node _head = getHeadNode();
        if (_head == null) {
            head = node;
            return;
        }
        head = node;
        head.next = _head;
        _head.prevNode = head;
    }

    /**
     * 类似栈的pop方法，取头 并删除
     * @Title: deleteHeadNode
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author admin
     * @return
     * @throws
     */
    protected Node deleteHeadNode() {
        Node _head = getHeadNode();
        if (_head.next == null) {
            head = null;
            return _head;
        }
        head = _head.next;
        head.next = _head.next.next;
        head.prevNode = null;
        return head;
    }

    /**
     * 删除指定node
     * @Title: deleteNode
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author admin
     * @param node
     * @throws
     */
    public void deleteNode(Node node) {
        Node _head = getHeadNode();
        if (head==node) {
            deleteHeadNode();
            return;
        }
        while (_head.next != null) {
            if (_head.next == node) {
                if (_head.next.next != null) {
                    _head.next = _head.next.next;
                    _head.next.prevNode = _head;
                }
                else {
                    _head.next = null;
                }
                break;
            }
            _head = _head.next;
        }
    }

    public static void main(String[] args) {
        DoubleDirectionLink directionLink = new DoubleDirectionLink();
        DoubleDirectionLink.Node<String> node1 = directionLink.new Node(" 1 ");
        directionLink.addHeadNode(node1);
        DoubleDirectionLink.Node<String> node2 = directionLink.new Node(" C ");
        directionLink.addHeadNode(node2);
        DoubleDirectionLink.Node<String> node3 = directionLink.new Node(" A ");
        directionLink.addHeadNode(node3);
        DoubleDirectionLink.Node<String> node4 = directionLink.new Node(" 4 ");
        directionLink.addLastNode(node4);
        System.out.println(directionLink.iterator());
        // directionLink.deleteHeadNode();
        System.out.println(directionLink.getHeadNode());
        directionLink.deleteNode(node3);
        System.out.println(directionLink.iterator());
    }
}
