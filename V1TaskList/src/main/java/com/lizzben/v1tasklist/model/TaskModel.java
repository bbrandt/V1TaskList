package com.lizzben.v1tasklist.model;

import com.lizzben.v1tasklist.V1.V1Connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Remove me...
 */
public class TaskModel {
    private List<Task> tasks = new ArrayList<Task>();
    private Map<String, Task> task_map = new HashMap<String, Task>();

    public TaskModel() throws Exception {
        V1Connection v1Connection = new V1Connection();
        v1Connection.GetTasks();

    }
}
