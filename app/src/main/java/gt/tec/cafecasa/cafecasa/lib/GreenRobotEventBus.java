package gt.tec.cafecasa.cafecasa.lib;

import gt.tec.cafecasa.cafecasa.lib.base.EventBus;

/**
 * Created by javie on 11/12/2017.
 */

public class GreenRobotEventBus implements EventBus {
    private org.greenrobot.eventbus.EventBus bus;

    public GreenRobotEventBus(org.greenrobot.eventbus.EventBus bus) {
        this.bus = bus;
    }

    @Override
    public void register(Object sub) {
        bus.register(sub);
    }

    @Override
    public void unRegister(Object sub) {
        bus.unregister(sub);
    }

    @Override
    public void post(Object sub) {
        bus.post(sub);
    }
}
