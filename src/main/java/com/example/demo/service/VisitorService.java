// package com.example.demo.service;
// import com.example.demo.model.Visitor;
// import java.util.List;
// public interface VisitorService {
//     Visitor createVisitor(Visitor visitor);
//     Visitor getVisitorById(Long id);
//     List<Visitor> getAllVisitors();
// }

package com.example.demo.service;

import com.example.demo.model.Visitor;
import java.util.List;

public interface VisitorService {
    Visitor save(Visitor visitor);
    List<Visitor> getAll();
}
