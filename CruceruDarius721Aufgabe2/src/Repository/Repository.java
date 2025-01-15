package Repository;



import Model.HasId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository<T extends HasId>implements IRepository<T> {
    private List<T> items = new ArrayList<>();

    @Override
    public void create(T obj) {
        if (obj != null && obj.getId() != null) {
            items.add(obj);
        }
    }

    @Override
    public T get(Integer id) {
        return items.stream().filter(obj -> obj.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void update(T obj) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getId() == obj.getId()) {
                items.set(i, obj);
                return;
            }
        }
    }

    @Override
    public void delete(Integer id) {
        items.removeIf(obj->obj.getId()==id);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(items);
    }
}