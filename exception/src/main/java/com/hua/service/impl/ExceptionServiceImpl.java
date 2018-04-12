/**
 * ExceptionServiceImpl.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.service.impl;

import com.hua.service.ExceptionService;

/**
 * ExceptionServiceImpl
 * 描述: 异常 - 服务
 * @author  qye.zheng
 */
public final class ExceptionServiceImpl extends CoreServiceImpl implements
		ExceptionService
{

	/**
	 	Java异常处理的原则和技巧

　　1、避免过大的try块，不要把不会出现异常的代码放到try块里面，尽量保持一个try块对应一个或多个异常。

　　2、细化异常的类型，不要不管什么类型的异常都写成Excetpion。

　　3、catch块尽量保持一个块捕获一类异常，不要忽略捕获的异常，捕获到后要么处理，要么转译，要么重新抛出新类型的异常。

　　4、不要把自己能处理的异常抛给别人。

　　5、不要用try...catch参与控制程序流程，异常控制的根本目的是处理程序的非正常情况。
	 */
	
	/**
	 
	 异常链，在JDK1.4以后版本中，Throwable类支持异常链机制。Throwable 包含了其线程创建时线程执行堆栈的快照。
	 它还包含了给出有关错误更多信息的消息字符串。最后，它还可以包含 cause(原因)：另一个导致此 throwable 抛出的 throwable。
	 它也称为异常链 设施，因为 cause 自身也会有 cause，依此类推，就形成了异常链，每个异常都是由另一个异常引起的。
	 
	 
	 
	 */
	
	/**
	 	第一、try语句不能单独存在，可以和catch、finally组成 try...catch、try...finally、try...catch...finally 三种结构，catch语句可以有0个或多个，
	 	try/finally语句最多一个，try、catch、finally这三个关键字均不能单独使用。

　　第二、try、catch、finally三个代码块中变量的作用域分别独立而不能相互访问。如果要在三个块中都可以访问，则需要将变量定义到这些块的外面。

　　第三、多个catch块时候，Java虚拟机会匹配其中一个异常类或其子类，就执行这个catch块，而不会再执行别的catch块。

　　第四、throw语句后不允许有紧跟其他语句，因为这些没有机会执行。

　　第五、如果一个方法调用了另外一个声明抛出异常的方法，那么这个方法要么处理异常，要么声明抛出。

　　那怎么判断一个方法可能会出现异常呢? 一般来说，方法声明的时候用了throws语句，
		方法中有throw语句，方法调用的方法声明有throws关键字。

　　throw和throws关键字的区别

　　throw用来抛出一个异常，在方法体内。语法格式为：throw 异常对象。

　　throws用来声明方法可能会抛出什么异常，在方法名后，语法格式为：throws 异常类型1，异常类型2...异常类型n。
	 
	 	捕获到异常后，将异常以新的类型的异常再抛出，这样做一般为了异常的信息更直观!
	 */
	
	/**
	
	 1) 异常概念
	 异常机制是指当程序出现错误后，程序如何处理。具体来说，异常机制提供了程序退出的安全通道。
	 当出现错误后，程序执行的流程发生改变，程序的控制权转移到[异常处理器]。 
	 
	 2) 异常处理的流程
		A. 遇到错误，方法立即结束，并不返回一个值；同时，抛出一个异常对象
		
		B. 调用该方法的程序也不会继续执行下去，而是搜索一个可以处理该异常的异常处理器，并执行其中的代码
	 
	 3) 异常特点
	 处理RuntimeException的原则是：如果出现RuntimeException，那么一定是程序员的错误。
	 例如，可以通过检查数组下标和数组边界来 避免 数组越界访问异常。 
	 
	 3.1.2 为什么要声明方法抛出异常？
	 方法是否抛出异常与方法返回值的类型一样重要。假设方法抛出异常确没有声明该方法将抛出异常，
	 那么客户程序员可以调用这个方法而且不用编写处理异常的代码。那么，一旦出现异常，那么这个异常就没有合适的异常控制器来解决。
	 
	3.1.3 为什么抛出的异常一定是已检查异常？ 
	RuntimeException与Error可以在任何代码中产生，它们不需要由程序员显示的抛出，一旦出现错误，
	那么相应的异常会被自动抛出。而已检查异常是由程序员抛出的，这分为两种情况：
	客户程序员调用会抛出异常的库函数（库函数的异常由库程序员抛出）；客户程序员自己使用throw语句抛出异常。
	遇到Error，程序员一般是无能为力的；遇到RuntimeException，那么一定是程序存在逻辑错误，
	要对程序进行修改（相当于调试的一种方法）；只有已检查异常才是程序员所关心的，程序应该且仅应该抛出或处理已检查异常。
	
	一般如果选择抛出 运行时异常，那么这样做可以让调用方无需去主动关注调用方式，但是一旦被调用方主动抛出运行时异常，
	那么可以选择给出一些具体的消息来提示调用者，运行时异常是一种比较低要求的异常，而不像已检查异常，一旦声明抛出，
	则调用处必须增加相应的异常控制器来处理.
	
	3.1.4 注意：覆盖父类某方法的子类方法不能抛出比父类方法更多的异常，所以，有时设计父类的方法时会声明抛出异常，
	但实际的实现方法的代码却并不抛出异常，这样做的目的就是为了方便子类方法覆盖父类方法时可以不?抛出异常。


	如果出现异常的线程为主线程，则整个程序运行终止;如果非主线程，则终止该线程，其他线程继续运行
	通过分析思考可以看出，越早处理异常消耗的资源和时间越小，产生影响的范围也越小。因此，不要把自己能处理的异常也抛给调用者。
	
	finally语句在任何情况下都必须执行的代码，这样可以保证一些在任何情况下都必须执行代码的可靠性。
	比如，在数据库查询异常的时候，应该释放JDBC连接等等。finally语句先于return语句执行，而不论其先后位置，
	也不管是否try块出现异常。finally语句唯一不被执行的情况是方法执行了System.exit(int)方法。
	System.exit(int)的作用是终止当前正在运行的 Java 虚拟机。
	
	finally语句块中不能通过给变量赋新值来改变return的返回值，也建议不要在finally块中使用return语句，没有意义还容易导致错误。
	
	 */
	
	
	/**
	
	异常(exception)
	异常程序运行不正常的一个总体概念，程序发生各种程度的错误，为了更好地发现问题、处理异常
	以及更好地运行程序；方法声明抛出异常，是向调用者发出预警信息，提示调用者需要考虑并注意
	这个情况；方法自身直接处理异常，而不玩外抛出，这样方法内部就需要通过返回值来通知调用者，
	以及具备方法使用上的描述(例如 在什么情况下，会产生什么结果).
	
	异常类结构
	java.lang.Throwable
	--java.lang.Error
	--java.lang.Exception (直接继承此异常的子类是 已检查异常)
	----java.lang.RuntimeException (直接继承此异常的子类是 运行时异常)
	
	
	System.exit(0); // 终止JVM，退出程序
	正常退出: Runtime.getRuntime().exit(0); 或者 System.exit(0)
	异常退出: Runtime.getRuntime().exit(1); 或者 System.exit(1)
	
	捕获到异常
	从try{}开始，发生了异常，不再往下执行，匹配到相应的catch，catch执行完毕，跳到finally{}执行。
	
	没捕获到异常
	从try{}开始，发生了异常，不再往下执行，但没有catch匹配，跳到finally{}中执行。
	
	1）java.lang.Error 是系统级错误，程序无法处理！
	
	2）java.lang.Exception 是程序可捕获并处理的异常
	
	3）java.lang.RuntimeException 和 java.lang.Error 的子类异常，是可处理可不处理的异常。
	
	4）凡是直接继承Exception的异常，都是程序必须处理的异常。
	
	5）运行时异常(未检查异常): 编译的时候，编译器没有检查出错误，而是程序运行之后报的异常。
	
	6）已检查异常: 需要用try...catch...捕获
	
	7）throw 异常对象; // 抛出一个异常对象异常抛出之后，下面的代码将不再执行，流程转向方法的调用处。
	
	8）throws 异常类,...  // 多个异常抛出声明
	
	9）返回之前: try/catch中有return返回值，都是先执行finally语句，最后执行返回值语句；也即，返回之前，先执行finally语句块。
	
	10）catch_顺序: 先捕获底层异常，再捕获上层异常。
	
	11）没有处理的异常，可以用throws在方法头声明，把异常抛给调用者，如果都没有处理，最后将抛给JVM处理。(Unhandled未处理)
	
	12）重点: 对于可恢复的错误-使用已检查异常，不可恢复的错误-使用运行时异常。
	
	13）在finally中要关闭资源。
	
	未检查异常
	
	常见_运行时_异常
	1）ArithmeticException 	ArrayStoreException
	2）IndexOutOfBoundsException
	3）ClassCastException
	4）NullPointerException		StartException
	5）NoSuchElementException		SecurityException
	6）UnsupportedOperationException
	7）EmptyStackException	IllegalArgumentException
	8）IllegalStateException 	IllegalAccessException
	
	凡是可能是null的对象，在调用其成员之前，都应该判断其是否为空，如果为空，则不能调用其成员。
	if (null != xxx) {}
	如果需要访问集合/数组中的对象的同时访问此对象的方法，就需要同时判断: null != set && 0 != set.size()
	 即同时满足集合对象不为空，而且集合的长度不为0。
		 
		 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 */

}
