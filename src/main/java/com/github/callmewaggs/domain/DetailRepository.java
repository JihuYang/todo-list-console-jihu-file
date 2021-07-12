package com.github.callmewaggs.domain;

import java.util.ArrayList;

import java.util.List;

/** Detail에 대한 저장소 역할 */
public class DetailRepository {

  private List<Detail> detailList;

  public DetailRepository() {
    this.detailList = new ArrayList<>();
  }

  public void add(Detail detail) {
	  detailList.add(detail);
  }

  public void remove(Detail detail) {
    detailList.remove(detail);
  }

  public int size() {
    return detailList.size();
  }

  public Detail findDetailId(long TodoId) {
	    return detailList.stream()
	        .filter(detail -> detail.getTodoId() == TodoId)
	        .findFirst()
	        .orElseThrow(() -> new IllegalStateException("잘못된 id가 입력되었습니다. id를 다시 확인해 주세요."));
  }

}
