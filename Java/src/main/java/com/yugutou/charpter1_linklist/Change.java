package com.yugutou.charpter1_linklist;


import java.util.ArrayList;
import java.util.List;

/**
 * @author by GOATLi
 * date: 2023-10-20.
 */
public class Change {
    public static void main(String[] args) {
        // aa:Java	ab:Java	ba:CPP	bb:CPP	ca:Python	cb:Python
        Student head = initStudent();

        // 新增数据

        BaseStudent[] addList = new BaseStudent[3];
        addList[0] = (new BaseStudent("cc", "Python"));
        addList[1] = (new BaseStudent("bc", "CPP"));
        addList[2] = (new BaseStudent("ac", "Java"));

        // 新增方法
        head = add(head, addList);

        System.out.println(toString(head));
    }

    /**
     * 获取初始数据
     *
     * @return
     */
    public static Student initStudent() {
        // 1.获取List集合
        BaseStudent[] initList = getList();

        // 2.对集合进行遍历
        Student head = null, cur = null;
        for (int i = 0; i < initList.length; i++) {
            BaseStudent baseInfo = initList[i];
            Student node = new Student(baseInfo.getName(), baseInfo.getLanguage());
            if (i == 0) {
                head = node;
                cur = head;
            } else {
                cur.next = node;
                cur = cur.next;
            }
            cur.next = null;
        }

        return head;
    }

    public static BaseStudent[] getList() {
        BaseStudent[] initList = new BaseStudent[9];
        initList[0] = (new BaseStudent("DummyJava", "Java"));
        initList[1] = (new BaseStudent("aa", "Java"));
        initList[2] = (new BaseStudent("ab", "Java"));
        initList[3] = (new BaseStudent("DummyCPP", "CPP"));
        initList[4] = (new BaseStudent("ba", "CPP"));
        initList[5] = (new BaseStudent("bb", "CPP"));
        initList[6] = (new BaseStudent("DummyPython", "Python"));
        initList[7] = (new BaseStudent("ca", "Python"));
        initList[8] = (new BaseStudent("cb", "Python"));
        return initList;
    }

    /**
     * 新增接口
     *
     * @param head      头结点
     * @param toAddData 需要添加的数据
     * @return
     */
    public static Student add(Student head, BaseStudent[] toAddData) {

        if (head == null) return null;

        // 遍历一次连表 查询出最后一个语言的指针位置
        Student cur = head;
        Student lastJava = head;
        Student lastCPP = head;
        Student lastPython = head;
        while (cur != null && cur.next != null) {
            if ("DummyCPP".equals(cur.next.name)) lastJava = cur;
            if ("DummyPython".equals(cur.next.name)) lastCPP = cur;
            cur = cur.next;
            lastPython = cur;
        }

        for (BaseStudent toAddDatum : toAddData) {
            String name = toAddDatum.getName();
            String language = toAddDatum.getLanguage();
            Student node = new Student(name, language);

            switch (language) {
                case "Java":
                    node.next = lastJava.next;
                    lastJava.next = node;
                    lastJava = node;
                    break;
                case "CPP":
                    node.next = lastCPP.next;
                    lastCPP.next = node;
                    lastCPP = node;
                    break;
                case "Python":
                    node.next = lastPython.next;
                    lastPython.next = node;
                    lastPython = node;
                    break;
            }
        }

        return head;
    }

    /**
     * 输出链表
     *
     * @param head 头节点
     */
    public static String toString(Student head) {
        Student current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            String str = current.name + ":" + current.language;
            sb.append(str).append("\t");
            current = current.next;
        }
        return sb.toString();
    }
}

/**
 * name: 姓名
 * language：语言
 */
class Student {
    String name;
    String language;
    Student next;

    Student(String name, String language) {
        this.name = name;
        this.language = language;
    }
}

class BaseStudent {
    String name;
    String language;

    BaseStudent(String name, String language) {
        this.language = language;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
