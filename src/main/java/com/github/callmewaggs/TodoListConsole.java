package com.github.callmewaggs;

import com.github.callmewaggs.domain.TodoRepository;
import com.github.callmewaggs.menu.TodoMenu;
import com.github.callmewaggs.menu.TodoMenuParameter;
import com.github.callmewaggs.processor.TodoProcessor;
import java.util.Map;

/** 
 * 실행 가능한 기능들을 사용자의 입력과 매핑시켜 적절한 processor 를 실행시킴  
 */
public class TodoListConsole {

  private Map<TodoMenu, TodoProcessor> todoProcessorMapping;
  private TodoRepository todoRepository;
  private IOHelper ioHelper;

  /** setter */
  public TodoListConsole(
      Map<TodoMenu, TodoProcessor> todoProcessorMapping,
      TodoRepository todoRepository,
      IOHelper ioHelper) {
    this.todoProcessorMapping = todoProcessorMapping;
    this.todoRepository = todoRepository;
    this.ioHelper = ioHelper;
  }

  void start() {
    ioHelper.printHelloMessage();
    ioHelper.printMenuWithExample();
    while (true) {
      try {
        String input = ioHelper.inputCommand();
        TodoMenuParameter todoMenuParameter = TodoMenuParameter.parse(input);
        TodoMenu menu = todoMenuParameter.getMenu();
        if (menu == TodoMenu.QUIT) {
          break;
        }
        if (menu == TodoMenu.SHOW_LIST) {
          ioHelper.printTodoList(todoRepository.findAll());
          continue;
        }
        if (menu == TodoMenu.SEARCH) {
          ioHelper.printMessage("입력하신 ["+ todoMenuParameter.getContent() + "] 를 포함하는 할일을 검색한 결과입니다. ");

          //for문 사용하여 검색 
          //ioHelper.printTodoList(todoRepository.searchAll(todoMenuParameter.getContent()));
        	
          //stream 사용하여 검색 
          ioHelper.printTodoList(todoRepository.searchAllStream(todoMenuParameter.getContent()));
          continue;
        }
        if (menu == TodoMenu.CHECK) {
            //for문 사용하여 미완료된 할 일을 보여준다.  
            ioHelper.printMessage("완료되지 않은 할일 리스트입니다. ");
            ioHelper.printTodoList(todoRepository.check());
            continue;
          }        
        TodoProcessor todoProcessor = todoProcessorMapping.get(menu);
        todoProcessor.run(todoMenuParameter);
        ioHelper.printTodoList(todoRepository.findAll());
      } catch (Exception e) {
        ioHelper.printMessage(e.getMessage());
      }
    }
  }
}
