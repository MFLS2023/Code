public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Person<String,Integer,String,Integer> person=new Person<>();
        person.setAge(20);
        person.setName("John");
        person.setGender("Male");
        person.setHeight(180);
        System.out.println(person.getAge()+" "+person.getName()+" "+person.getGender()+" "+person.getHeight());
    }

    public static class Person<T,A,B,C>{
        private T name;
        private A age;
        private B gender;
        private C height;

        public A getAge() {
            return age;
        }

        public void setAge(A age) {
            this.age = age;
        }

        public C getHeight() {
            return height;
        }

        public void setHeight(C height) {
            this.height = height;
        }

        public B getGender() {
            return gender;
        }

        public void setGender(B gender) {
            this.gender = gender;
        }

        public T getName() {
            return name;
        }

        public void setName(T name) {
            this.name = name;
        }

    }


}