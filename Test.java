
1) What will be the output of the program?

class A 
{
    final public int GetResult(int a, int b) { return 0; } 
} 
class B extends A 
{ 
    public int GetResult(int a, int b) {return 1; }  // методы с модификатором final не могут переопределятся
} 


public class Test 
{
    public static void main(String args[]) 
    { 
        B b = new B(); 
        System.out.println("x = " + b.GetResult(0, 1));  
    } 
}
	A.	x = 0
	B.	x = 1
	
	C.	Compilation fails. (correct answer) 
	
	D.	An exception is thrown at runtime.

	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
2) What will be the output of the program?

class SC2 
{
    public static void main(String [] args) 
    {
        SC2 s = new SC2();
        s.start();
    }

    void start() 
    {
        int a = 3;
        int b = 4;
        System.out.print(" " + 7 + 2 + " ");   // конкатенация строк -> 72     , 7 и 2 приводятся к строковому представлению
        System.out.print(a + b);               // сложение двух переменных -> 7 
        System.out.print(" " + a + b + " ");   // конкатенация строк -> 34,  a и b приводятся к строковому представлению
        System.out.print(foo() + a + b + " "); // конкатенация строк -> foo34 , т.к foo() возвращает строку "foo" , "a" привдится к String
        System.out.println(a + b + foo());     // сначало сложение a + b, затем результат конкатенируем с "foo" -> 7foo 
    }

    String foo() 
    {
        return "foo";
    }
}

	A.	9 7 7 foo 7 7foo
	B.	72 34 34 foo34 34foo  
	C.	9 7 7 foo34 34foo
	
	D.	72 7 34 foo34 7foo (correct answer) 

	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



3) What will be the output of the program?

class BoolArray 
{
    boolean[] b = new boolean[3];
    int count = 0; // 1

    void set(boolean [] x, int i) 
    {
        x[i] = true;
        ++count;
    }

	
    public static void main(String[] args) 
    {
        BoolArray ba = new BoolArray();
		
        ba.set(ba.b, 0);
        ba.set(ba.b, 2);
        ba.test();
    }

    void test() 
    {
        if ( b[0] && b[1] | b[2] ) /*Логический оператор | (ИЛИ) в отличии от сокращенного оператора || (ИЛИ) Работает и с правым, и с левым операндом.
		                            (b[0] = true ) && ((b[1] = false) | (b[2] = true))
									true && true
									true*/
									
            count++;     // т.к. - true, инкрементируем переменную count = 2 -> count = 3.
        if ( b[1] && b[(++count - 2)] )
            count += 7;
        System.out.println("count = " + count);
    }
}
	A.	count = 0
	B.	count = 2
	
	C.	count = 3 (correct answer)
	
	D.	count = 4

	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
4) What will be the output of the program?

Float f = new Float("12");  

switch (f)   // switch не может принимать значения типа float. 
{
    case 12: System.out.println("Twelve"); 
    case 0: System.out.println("Zero"); 
    default: System.out.println("Default"); 
}
	A.Zero
	B.Twelve
	C.Default
	
	D.Compilation fails (correct answer)
	
	
	
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	

5) 
public class BoolTest 
{
    public static void main(String[] args) 
    {
        Boolean b1 = new Boolean("false");
		
        boolean b2;
		
        b2 = b1.booleanValue(); // booleanValue() -> Returns the value of this Boolean object as a boolean primitive. -> b2 = false
        if (!b2)                // Инвертируем b2 с помощью !(Логическое унарное НЕ) получаем b2 = true
        {
            b2 = true;   // b2 = true, только внутри if()
            System.out.print("x"); // x выведится на консоль
        }
		
		
        if (b1 & b2) /* Line 13 */ // т.к. (b1 = false) & (b2 = false) 
			                       //  получим if(false) -> if - не сработает
        {
            System.out.print("y ");
        }
        System.out.println("z"); // z выведет на консоль
    }
}


	A.z
	
	B.x z (correct answer)
	
	C.y z
	D.Compilation fails.


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	

6) What will be the output of the program?

class Two 
{
    byte x;
}

class PassO
{
    public static void main(String [] args) 
    {
        PassO p = new PassO();
        p.start();
    }

    void start() 
    {
        Two t = new Two();
        System.out.print(t.x + " "); // Выведет "0" на консоль, т.к x не проинииализирован
		
        Two t2 = fix(t);  // Создали ссылку(указатель) t2, Передали  в метод fix() объек t и получили объект  t  c полем x = 42
        System.out.println(t.x + " " + t2.x); // Выведет на консоль 42 42    т.к. и t, и t2 указывают на один и тот же объек с переменной экземпляра x = 42.
    }

    Two fix(Two tt) // получили ссылочную переменную типа Two 
    {
        tt.x = 42;   // Записали значение 42 в переменную экземпляра x.
        return tt;    // возвращаем значение
     }
}
	A.null null 42	
	B.0 0 42
	
	C.0 42 42 (correct answer)
	
	D.0 0 0
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	
	

7) What will be the output of the program?

public class If2 
{
    static boolean b1, b2;
	
    public static void main(String [] args) 
    {
        int x = 0;
		
        if ( !b1 ) /* Line 7 */     // Будет true, т.к. b1 = false по умолчанию, и мы инвертировали значение с помощью оператора "!"
            if ( !b2 ) /* Line 9 */ // Так же будет true
            {
                b1 = true;
                x++; // Инкрементировали x получили x = 1
                if ( 5 > 6 ) // Условие не выполняется
                {
                    x++;
                }
				
                if ( !b1 ) // Это вложенный if, следовательно b1 = true, ->  if (!b1) -> if(false), Условие не выполняется
                    x = x + 10;
                else if ( b2 = true ) /* Line 19 */ // Мы сдесь можем использовать оператор присвоения "=" т.к. b2 имеет тип boolean
                    x = x + 100; // x = 101
                else if ( b1 | b2 ) /* Line 21 */ // Этот if else не отработает т.к у нас уже отработал один else if ( b2 = true )
                    x = x + 1000;
            }
        }
        System.out.println(x); // Выведет 101
    }
}
	A.	0
	B.	1
	
	C.	101 (correct answer)
	
	D.	111

	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	

8) What will be the output of the program?

int i = 0; 

while(1) // Не сработает т.к. сдесь предикат  (должно возвращать значение булевого типа)
{
    if(i == 4) 
    {
        break;
    } 
    ++i; 
} 

System.out.println("i = " + i);
	A. i = 0
	B. i = 3
	C. i = 4
	
	D. Compilation fails.(correct answer)

	

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
9) public class Test { }
   What is the prototype of the default constructor?
	
	A. Test( )
	B. Test(void)
	
	C. public Test( )(correct answer)
	
	D. public Test(void)
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	
	

10)

 import java.awt.Button;

class CompareReference 
{
    public static void main(String [] args) 
    {
        float f = 42.0f;
        float [] f1 = new float[2];
        float [] f2 = new float[2];
		
        float [] f3 = f1;
		
        long x = 42;
        f1[0] = 42.0f;
    }
}
	
    which three statements are true?

	f1 == f2    // Ссылки указзывают на разные объекты  -> false
	f1 == f3    // Ссылки указывают на один и тот же объект -> true
	f2 == f1[1] // неведомое что-то ) Вообще не скомпелируется несовместимые между собой типы
	x == f1[0]  // примитив x сравнивается с содержимым объекта -> true т.к. содержимое одинаковое
	f == f1[0]  // тоже самое, будет true,  
	
	A. 1, 2 and 3
	B. 2, 4 and 5 (correct answer)
	C. 3, 4 and 5
	D. 1, 4 and 5

	

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
12) public class MyOuter 
{
    public static class MyInner 
    {
        public static void foo() { }
    }
}
which statement, if placed in a class other than MyOuter or MyInner, instantiates an instance of the nested class?



	A. MyOuter.MyInner m = new MyOuter.MyInner(); (correct answer) // Доступ к внутреннему классу осуществляется через обрамляющий класс.
	
	B. MyOuter.MyInner mi = new MyInner();
	C. MyOuter m = new MyOuter();
       MyOuter.MyInner mi = m.new MyOuter.MyInner();
	D. MyInner mi = new MyOuter.MyInner();



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	

13)


interface Base {
	
	
    boolean m1 ();
    byte m2(short s); 
}



which two code fragments will compile?



***********************************************************

interface Base2 implements Base {                               //  не-а ) Нужно использовать ключевое слово extends
	
}

***********************************************************

abstract class Class2 extends Base {                             // Должны использовать ключевое слово implements

public boolean m1(){ 
return true; 
}
}

***********************************************************

abstract class Class2 implements Base {
	
}

***********************************************************

abstract class Class2 implements Base { 

public boolean m1(){ return (7 > 4);
 }
}

***********************************************************

abstract class Class2 implements Base {
	protected boolean m1(){                                  // Мы не можем  использовать более закрытый модификатор доступа , не скомпилируется
	return (5 > 7) 
}
}

***********************************************************

	A.	1 and 2 
	B.	2 and 3
	
	C.	3 and 4 (correct answer)
	
	D.	1 and 5 
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
14) 

class A 
{  
    protected int method1(int a, int b) 
    {
        return 0; 
    } 
}


Which is valid in a class that extends class A?


	A.	public int method1(int a, int b) {return 0; } (correct answer)
	
	B.	private int method1(int a, int b) { return 0; }
	C.	public short method1(int a, int b) { return 0; }
	D.	static protected int method1(int a, int b) { return 0; }
	

	
	
	
	
	
	
	
	
	
	