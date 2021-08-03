package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.ui.custom;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {

    private static Activator instance = null;

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        setInstance(this);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        setInstance(null);
        super.stop(context);
    }

    private static void setInstance(Activator instance) {
        Activator.instance = instance;
    }

    public static Activator getInstance() {
        return instance;
    }

}
