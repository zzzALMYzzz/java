package lr7;

class SuperClass {
    private String field;

    public SuperClass(String field) {
        this.field = field;
    }
    
    @Override
    public String toString() {
        return "Класс: " + this.getClass().getSimpleName() + ", Поле: '" + field + "'";
    }
}

class SubClass extends SuperClass {
    private String secondField;

    public SubClass(String firstField) {
        super(firstField);
    }

    public SubClass(String firstField, String secondField) {
        super(firstField);
        this.secondField = secondField;
    }
    
    @Override
    public String toString() {
        if(secondField != null)
            return "Класс: " + this.getClass().getSimpleName() + ", Первое поле: '" + super.toString().split(",")[1].trim() + "', Второе поле: '" + secondField + "'";
        else
            return "Класс: " + this.getClass().getSimpleName() + ", Первое поле: '" + super.toString().split(",")[1].trim() + "'";
    }
}

public class example1 {
    public static void main(String[] args) {
        SuperClass superObj = new SuperClass("Super text");
        SubClass subObjOneArg = new SubClass("Sub text");
        SubClass subObjTwoArgs = new SubClass("First text", "Second text");
        
        System.out.println(superObj.toString());
        System.out.println(subObjOneArg.toString());
        System.out.println(subObjTwoArgs.toString());
    }
}
