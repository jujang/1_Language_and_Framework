class Student{
    String name;
    Student(String name){
        this.name = name;
    }
//    public boolean equals(Object obj) {  // overriding
//        Student _obj = (Student)obj;
//        return this.name == _obj.name;
//    }
}

class ObjectDemo {
    public static void main(String[] args) {
//        String s1 = new String("egoing");
//        String s2 = new String("egoing");
        Student s1 = new Student("egoing");
        Student s2 = new Student("egoing");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}