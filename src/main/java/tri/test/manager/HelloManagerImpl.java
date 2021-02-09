package tri.test.manager;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
class HelloManagerImpl implements HelloManager {

    @Override
    public String getHello() {
        return "Hello world";
    }
}
