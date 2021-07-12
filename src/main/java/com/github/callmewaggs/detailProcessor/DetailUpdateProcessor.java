package com.github.callmewaggs.detailProcessor;

import com.github.callmewaggs.domain.Detail;
import com.github.callmewaggs.domain.DetailRepository;
import com.github.callmewaggs.menu.TodoMenuParameter;

/** Detail 업데이트 */
public class DetailUpdateProcessor implements DetailProcessor {

	  private DetailRepository detailRepository;

	  public DetailUpdateProcessor(DetailRepository detailRepository) {
	    this.detailRepository = detailRepository;
	  }

  @Override
  public void run(TodoMenuParameter todoMenuParameter) {
    Detail toBeUpdated = detailRepository.findDetailId(todoMenuParameter.getId());
    toBeUpdated.update(todoMenuParameter.getContent());
  }
}
