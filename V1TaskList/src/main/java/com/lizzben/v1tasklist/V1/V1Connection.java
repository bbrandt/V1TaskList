package com.lizzben.v1tasklist.V1;

import com.versionone.Oid;
import com.versionone.apiclient.*;

public class V1Connection {

    private EnvironmentContext _context;

    private IMetaModel _metaModel;
    private IServices _services;
    private V1Configuration _config;

    public V1Connection() throws Exception {

        _context = new EnvironmentContext();

        _metaModel = _context.getMetaModel();
        _services = _context.getServices();
        _config = _context.getV1Configuration();
    }

    public Asset[] GetTasks() throws Exception {
        IAssetType taskType = _metaModel.getAssetType("Task");
        Query query = new Query(taskType);
        IAttributeDefinition nameAttribute = taskType.getAttributeDefinition("Name");
        IAttributeDefinition todoAttribute = taskType.getAttributeDefinition("ToDo");
        query.getSelection().add(nameAttribute);
        query.getSelection().add(todoAttribute);

        FilterTerm toDoTerm = new FilterTerm(todoAttribute);
        toDoTerm.equal(0);
        query.setFilter(toDoTerm);
        QueryResult result = _services.retrieve(query);

        for (Asset task : result.getAssets()) {
            System.out.println(task.getOid().getToken());
            System.out.println(task.getAttribute(nameAttribute).getValue());
            System.out.println(task.getAttribute(todoAttribute).getValue());
            System.out.println();
        }
        /***** OUTPUT *****
         Task:1153
         Code Review
         0

         Task:1154
         Design Component
         0 ...
         ******************/

        return result.getAssets();
    }
}
