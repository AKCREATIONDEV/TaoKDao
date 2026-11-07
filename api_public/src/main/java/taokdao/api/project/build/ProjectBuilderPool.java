package taokdao.api.project.build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;


public class ProjectBuilderPool {
    private static ProjectBuilderPool instance = new ProjectBuilderPool();
    public HashMap<String, IProjectBuilder> map = new HashMap<>();

    public static ProjectBuilderPool getInstance() {
        return instance;
    }

    public static ProjectBuilderPool newInstance() {
        instance = new ProjectBuilderPool();
        return instance;
    }

    /**
     * @param o T
     * @return isSuccess
     */
    public boolean add(@NonNull IProjectBuilder o) {
        if (map.get(o.id()) == null) {
            map.put(o.id(), o);
            return true;
        }
        return false;
    }

    @Nullable
    public IProjectBuilder get(@NonNull String id) {
        return map.get(id);
    }

    public void addAll(@NonNull IProjectBuilder[] os) {
        for (IProjectBuilder o : os) {
            add(o);
        }
    }

    public IProjectBuilder remove(@NonNull String id) {
        return map.remove(id);
    }

    public void remove(@NonNull IProjectBuilder o) {
        remove(o.id());
    }

    public void removeAll(@NonNull IProjectBuilder[] os) {
        for (IProjectBuilder o : os) {
            remove(o);
        }
    }

    public void removeAll(@NonNull Collection<IProjectBuilder> os) {
        for (IProjectBuilder o : os) {
            remove(o);
        }
    }

    public boolean contains(@NonNull String id) {
        return map.get(id) != null;
    }

    public boolean contains(@NonNull IProjectBuilder o) {
        return contains(o.id());
    }

    public boolean containsAll(@NonNull IProjectBuilder[] os) {
        return containsAll(Arrays.asList(os));
    }

    public boolean containsAll(@NonNull Collection<IProjectBuilder> os) {
        return getAll().containsAll(os);
    }

    public HashSet<IProjectBuilder> getAll() {
        return new HashSet<>(map.values());
    }

    public void clear() {
        map.clear();
    }
}
