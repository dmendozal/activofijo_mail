package Negocio;

import java.util.List;

public interface CRUD<T> {

        public void add(T t) throws Exception;
        public void update(T t) throws Exception;
        public void delete(T t) throws Exception;
//        T getById(int t) throws Exception;
        public List<T> getAll() throws Exception;

}
