package com.github.callmewaggs.detailProcessor;

import com.github.callmewaggs.domain.Detail;
import com.github.callmewaggs.domain.DetailRepository;
import com.github.callmewaggs.menu.TodoMenuParameter;

/** Memo 삭제 */
public class DetailRemoveProcessor implements DetailProcessor {

  private DetailRepository detailRepository;

  public DetailRemoveProcessor(DetailRepository detailRepository) {
    this.detailRepository = detailRepository;
  }

  @Override
  public void run(TodoMenuParameter todoMenuParameter) {
	Detail toBeRemoved = detailRepository.findDetailId(todoMenuParameter.getId());
	detailRepository.remove(toBeRemoved);
  }
}
