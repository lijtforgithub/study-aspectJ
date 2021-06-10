/**
 * @author LiJingTang
 * @version 2015年9月21日上午11:28:27
 */
package com.ljt.study.aspect;

/**
	Spring Aop采用的动态织入，而Aspectj是静态织入。静态织入：指在编译时期就织入，即：编译出来的class文件，字节码就已经被织入了。
	动态织入又分静动两种，静则指织入过程只在第一次调用时执行；动则指根据代码动态运行的中间状态来决定如何操作，每次调用Target的时候都执行。
  
 	pointcut的主要类型
 	
 	Methods and Constructors 
	call(Signature) every call to any method or constructor matching Signature at the call site(方法和构造函数的调用点) 
	xecution(Signature) every execution of any method or constructor matching Signature(方法和构造函数的执行点) 
	
	Fields 
	get(Signature) every reference to any field matching Signature(属性的读操作) 
	set(Signature) every assignment to any field matching Signature. The assigned value can be exposed with anargs pointcut(属性的写操作)
	 
	Exception Handlers 
	handler(TypePattern) every exception handler for any Throwable type in TypePattern. The exception value can be exposed with anargs pointcut(异常处理执行)
	
	Advice 
	adviceexecution() every execution of any piece of advice(Advice执行) 
	
	Initialization 
	staticinitialization(TypePattern) every execution of a static initializer for any type in TypePattern  (类初始化)
	initialization(Signature) every initialization of an object when the first constructor called in the type matchesSignature, 
		encompassing the return from the super constructor call to the return of the first-called constructor (对象初始化) 
	preinitialization(Signature) every pre-initialization of an object when the first constructor called in the type matchesSignature, 
		encompassing the entry of the first-called constructor to the call to the super constructor (对象预先初始化) 

	Lexical 
	within(TypePattern) every join point from code defined in a type in TypePattern(捕获在指定类或者方面中的程序体中的所有连接点，包括内部类)
	withincode(Signature) every join point from code defined in a method or constructor matching Signature(用于捕获在构造器或者方法中的所有连接点，包括在其中的本地类) 

	Instanceof checks and context exposure 
	this(Type or Id) every join point when the currently executing object is an instance of Type or Id's type(所有Type or id 的实例的执行点，匹配所有的连接点，如方法调用，属性设置，当前的执行对象为Account，或者其子类。) 
	target(Type or Id) every join point when the target executing object is an instance of Type or Id's type(配所有的连接点，目标对象为Type或Id) 
	args(Type or Id, ...) every join point when the arguments are instances of Types or the types of the Ids(参数类型为Type) 

	Control Flow 
	cflow(Pointcut) every join point in the control flow of each join point P picked out byPointcut, including P itself (捕获所有的连接点在指定的方法执行中，包括执行方法本身) 
	cflowbelow(Pointcut) every join point below the control flow of each join point P picked out byPointcut; does not include P itself(捕获所有的连接点在指定的方法执行中，除了执行方法本身) 
	
	Conditional 
	if(Expression) every join point when the boolean Expression is true 

	Combination　(逻辑／结合操作) 
	! Pointcut : every join point not picked out by Pointcut 
	Pointcut0 && Pointcut1 : each join point picked out by both Pointcut0 and Pointcut1 
	Pointcut0 || Pointcut1 : each join point picked out by either Pointcut0 or Pointcut1 
	( Pointcut ) each join point picked out by Pointcut 



 	  前面说过pointcut基于正则的语法，那么肯定也支持通配符，含义如下：

 	* 表示任何数量的字符，除了(.) 
 	.. 表示任何数量的字符包括任何数量的(.) 
 	+ 描述指定类型的任何子类或者子接口
 	同java一样，提供了一元和二元的条件表达操作符。
 	一元操作符：!
	二元操作符：||和&&
	优先权同java



	call和execution

　　　语法结构：execution([修饰符]　返回值类型　方法名(参数)　［异常模式］)　　蓝色表示可选部分。

　　例子：
		•execution(public *.*(..))　　所有的public方法。
		•execution(* hello(..))            所有的hello()方法
		•execution(String hello(..))   所有返回值为String的hello方法。
		•execution(* hello(String))  　　所有参数为String类型的hello()
		•execution(* hello(String..))      至少有一个参数，且第一个参数类型为String的hello方法
		•execution(* com.aspect..*(..))  　所有com.aspect包，以及子孙包下的所有方法
		•execution(* com..*.*Dao.find*(..))　　com包下的所有一Dao结尾的类的一find开头的方法　　　

　　 接下来讲讲call和execution的区别，从字面理解：call为调用，而execution为执行。事实上他们的区别也确实如此。
	call捕获的joinpoint是签名方法的调用点，而execution捕获的则是执行点。一个是调用的地方，一个是执行的地方。
	withincode与within相似，不过withcode()接受的signature是方法，而不是类。用法，意思都差不多，只不过是使用场合不同。
	cfow()获取的是一个控制流程。他很少几乎不单独使用，一般与其他的pointcut 进行 &&运算。若要单独使用，一定要记得用!with()剔除asepct 本身。

 	
 	
 	说apsectj是动态、静态植入结合的。 那么Target()  this()就是属于他动态植入的方式，within是静态植入的。
 	故target(),this()需要在运行时才能确定那些被拦截。 比如刚才的例子，我们在给Animal加多一个实现类，用target() 他仍然可以被拦截。
 	所以target()和this()会用继承关系作用,也就是说：如果你的signature是一个基类，那么这个pointcut同时也会对他的子类也起作用。 
          另外target 和 this 可以获取他们对应的实例。  但是within没法作到。

    target()是指：我们pointcut 所选取的Join point 的所有者，直白点说就是： 指明拦截的方法属于那个类。
    this()是指： 我们pointcut 所选取的Join point 的调用的所有者，就是说：方法是在那个类中被调用的。

 */