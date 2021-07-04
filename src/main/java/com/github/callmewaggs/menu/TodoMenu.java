package com.github.callmewaggs.menu;

import java.util.Arrays;
import java.util.Optional;

/** enum type으로 각 메뉴마다 숫자 배정 */
public enum TodoMenu {
  QUIT("0"),

  SHOW_LIST("1"),

  CREATE("2"),

  UPDATE("3"),

  REMOVE("4"),

  FINISH("5"),
	
  SEARCH("6");

  /** menuNumber를 저장할 변수 선언  */
  private String menuNumber;

  /** menuNumber setter */
  TodoMenu(String menuNumber) {
    this.menuNumber = menuNumber;
  }

  /** 
   * 사용자가 입력한 메뉴 번호가 TodoMenu에 있는지 확인하는 테스트
   * filter() 메서드는 주어진 함수의 테스트를 통과하는 모든 요소를 모아 새로운 배열로 반환 
   * */
  public static TodoMenu fromMenuNumber(String menuNumber) {
    Optional<TodoMenu> todoMenu =
        Arrays.stream(TodoMenu.values()).filter(e -> e.menuNumber.equals(menuNumber)).findAny();
    if (!todoMenu.isPresent()) {
      throw new IllegalArgumentException(menuNumber + " is wrong menu. try again.");
    }
    return todoMenu.get();
  }
}
