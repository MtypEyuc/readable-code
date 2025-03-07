## 1. 아래의 코드를 리팩토링 하기.
### 1. 원본
```java
public boolean validateOrder(Order order) {
    if (order.getItems().size() == 0) {
        log.info("주문 항목이 없습니다.");
        return false;
    } else {
        if (order.getTotalPrice() > 0) {
            if (!order.hasCustomerInfo()) {
                log.info("사용자 정보가 없습니다.");
                return false;
            } else {
                return true;
            }
        } else if (!(order.getTotalPrice() > 0)) {
            log.info("올바르지 않은 총 가격입니다.");
            return false;
        }
    }
    return true;
}
```
- 메서드에 SOLID를 적용해야 한다.
- Items, CustomerInfo, TotalPrice를 호출하는 형태여야 한다.
- 코드의 목적은 `오더`를 받으면 주문이 유효한지 검증하는 메서드이다.
---
### 2. Main
```java
//public static void main(String[] args){
//    GameLevel gameLevel = new Middle();
//    InputHandler inputHandler = new ConsoleInputHandler();
//    OutputHandler outputHandler = new ConsoleOutputHandler();
//
//
//    Minesweeper minesweeper = new Minesweeper(gameLevel,inputHandler,outputHandler);
//    minesweeper.initialize();
//    minesweeper.run();
//}

public class Main {
    public static void main(String[] args) {
        Order order = new Order();

        ValidateOrder validateOrder = new ValidateOrder(order);
            validateOrder.showItems(), // getItems
            validateOrder.showCustomerInfo(), // hasCustomerInfo
            validateOrder.showTotalPrice(); // getTotalPrice
    }
}
```
- 메인 함수에서 동작 메서드를 호출하는 형식으로 작성한다.
---
### 3. 쪼개기
```java
public boolean ValidateOrder(Order order) {
    if (order.getItems().size() == 0) {
        getInfo();
        return false;
    } else {
        if (order.getTotalPrice() > 0) {
            if (!order.hasCustomerInfo()) {
                getCustomerInfo();
                return false;
            } else {
                return true;
            }
        } else if (!(order.getTotalPrice() > 0)) {
            totalPrice();
            return false;
        }
    }
    return true;
}
```
- 정해진 기능으로 동작하는 메서드로 나누어야 한다.
---
### 4. 기능 구현
```java
public interface orderValidate {
    boolean validate(Order order);
}
```
```java
public class showItems implements orderValidate {
    @Override
    public boolean validate(Order order) {
        if (order.getItems().isEmpty()) {
            ConsoleOutputHandler.getInfo(); // "주문 항목이 없습니다."
            return false;
        }
        return true;
    }
}
```
- 인터페이스를 정의하고 기능을 구현한다.
---

## 2. SOLID에 대하여 자기만의 언어로 정리해 봅시다.
이전에 실무 형식으로 스프링을 사용했을 때의 경험으로 애플리케이션 기능을 정의하고 구현하는 느낌으로 생각했다.

---
### 1. 추상화 (DIP,ISP)
- 유스케이스 모델에 따라 필요한 기능을 정리하고 목적에 맞게 생성한다.


- 애플리케이션의 기능을 정의한다. 해당 애플리케이션에서 동작하는 기능을 인터페이스로 문서화 한다.

---
### 2. 구체화(SRP, OCP, LSP)
- 인터페이스 기능을 구현할 모델을 설정하고 각자 하나의 역할을 담당하는 컨트롤러를 생성한다.


- 컨트롤러가 받아 오는 객체는 확장 가능하게 만들어야 한다.
