package se.moondrop.binarylife.active.repo;

import se.moondrop.binarylife.active.object.RepoObj;

public interface MDRepository {

    public void init();

    public boolean store(RepoObj object);

    public RepoObj retrieve(String userId, String name);
}
