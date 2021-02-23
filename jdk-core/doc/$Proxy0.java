package com.sun.proxy;

import com.hua.target.IBuyService;
import com.hua.target.IFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public final class $Proxy0 extends Proxy implements IFactory, IBuyService {
  private static Method m1;
  
  private static Method m5;
  
  private static Method m3;
  
  private static Method m2;
  
  private static Method m6;
  
  private static Method m4;
  
  private static Method m0;
  
  public $Proxy0(InvocationHandler paramInvocationHandler) {
    super(paramInvocationHandler);
  }
  
  public final boolean equals(Object paramObject) {
    try {
      return ((Boolean)this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final void manufacture(int paramInt) {
    try {
      this.h.invoke(this, m5, new Object[] { Integer.valueOf(paramInt) });
      return;
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final double query(int paramInt) {
    try {
      return ((Double)this.h.invoke(this, m3, new Object[] { Integer.valueOf(paramInt) })).doubleValue();
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final String toString() {
    try {
      return (String)this.h.invoke(this, m2, null);
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final void buy(int paramInt, double paramDouble) {
    try {
      this.h.invoke(this, m6, new Object[] { Integer.valueOf(paramInt), Double.valueOf(paramDouble) });
      return;
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final Boolean entry(String paramString) {
    try {
      return (Boolean)this.h.invoke(this, m4, new Object[] { paramString });
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  public final int hashCode() {
    try {
      return ((Integer)this.h.invoke(this, m0, null)).intValue();
    } catch (Error|RuntimeException error) {
      throw null;
    } catch (Throwable throwable) {
      throw new UndeclaredThrowableException(throwable);
    } 
  }
  
  static {
    try {
      m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[] { Class.forName("java.lang.Object") });
      m5 = Class.forName("com.hua.target.IFactory").getMethod("manufacture", new Class[] { int.class });
      m3 = Class.forName("com.hua.target.IFactory").getMethod("query", new Class[] { int.class });
      m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
      m6 = Class.forName("com.hua.target.IBuyService").getMethod("buy", new Class[] { int.class, double.class });
      m4 = Class.forName("com.hua.target.IFactory").getMethod("entry", new Class[] { Class.forName("java.lang.String") });
      m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
      return;
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new NoSuchMethodError(noSuchMethodException.getMessage());
    } catch (ClassNotFoundException classNotFoundException) {
      throw new NoClassDefFoundError(classNotFoundException.getMessage());
    } 
  }
}
