package com.github.callmewaggs;

import com.github.callmewaggs.detailProcessor.DetailCreateProcessor;
import com.github.callmewaggs.detailProcessor.DetailProcessor;
import com.github.callmewaggs.domain.IdGenerator;
import com.github.callmewaggs.domain.TodoRepository;
import com.github.callmewaggs.menu.TodoMenu;
import com.github.callmewaggs.processor.TodoCreateProcessor;
import com.github.callmewaggs.processor.TodoFinishProcessor;
import com.github.callmewaggs.processor.TodoProcessor;
import com.github.callmewaggs.processor.TodoRemoveProcessor;
import com.github.callmewaggs.processor.TodoUpdateProcessor;
import java.util.HashMap;
import java.util.Map;

public class TodoListConsoleMain {

  /** todoServicesMapping에 TodoMenu와 TodoProcessor주입 */
  public static void main(String[] args) {
    TodoRepository todoRepository = new TodoRepository();
    IdGenerator idGenerator = new IdGenerator();

    Map<TodoMenu, TodoProcessor> todoServicesMapping = new HashMap<>();
    Map<TodoMenu, DetailProcessor> detailServicesMapping = new HashMap<>();
   
    todoServicesMapping.put(
        TodoMenu.CREATE, new TodoCreateProcessor(todoRepository, idGenerator));
    todoServicesMapping.put(TodoMenu.UPDATE, new TodoUpdateProcessor(todoRepository));
    todoServicesMapping.put(TodoMenu.REMOVE, new TodoRemoveProcessor(todoRepository));
    todoServicesMapping.put(TodoMenu.FINISH, new TodoFinishProcessor(todoRepository));
    detailServicesMapping.put(
            TodoMenu.CREATEDETAIL, new DetailCreateProcessor(todoRepository));
    IOHelper ioHelper = new IOHelper();
    TodoListConsole todoListConsole =
        new TodoListConsole(todoServicesMapping, todoRepository, ioHelper);
    todoListConsole.start();
  }
}
