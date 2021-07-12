package com.github.callmewaggs.detailMenu;

import java.util.Arrays;
import java.util.Optional;

/** enum type으로 각 메뉴마다 숫자 배정 */
public enum DetailMenu {

  CREATEDETAIL("1"),

  UPDATEDETAIL("2"),

  REMOVEDETAIL("3");

  /** menuNumber를 저장할 변수 선언  */
  private String detailMenuNumber;

  /** menuNumber setter */
  DetailMenu(String detailMenuNumber) {
    this.detailMenuNumber = detailMenuNumber;
  }

  /** 
   * 사용자가 입력한 메뉴 번호가 TodoMenu에 있는지 확인하는 테스트
   * filter() 메서드는 주어진 함수의 테스트를 통과하는 모든 요소를 모아 새로운 배열로 반환 
   * */
  public static DetailMenu fromMenuNumber(String detailMenuNumber) {
    Optional<DetailMenu> detailMenu =
        Arrays.stream(DetailMenu.values()).filter(e -> e.detailMenuNumber.equals(detailMenuNumber)).findAny();
    if (!detailMenu.isPresent()) {
      throw new IllegalArgumentException(detailMenuNumber + " is wrong menu. try again.");
    }
    return detailMenu.get();
  }
}
