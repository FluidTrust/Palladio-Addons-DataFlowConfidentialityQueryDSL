package org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.internal;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.prolog4j.manager.IProverManager;

public class Activator extends Plugin {

    private static Activator instance;
    private ServiceReference<IProverManager> proverManagerReference;
    private IProverManager proverManager;

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        setInstance(this);
        proverManagerReference = context.getServiceReference(IProverManager.class);
        proverManager = context.getService(proverManagerReference);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        context.ungetService(proverManagerReference);
        proverManager = null;
        proverManagerReference = null;
        setInstance(null);
        super.stop(context);
    }

    private static void setInstance(Activator instance) {
        Activator.instance = instance;
    }

    public static Activator getInstance() {
        return Activator.instance;
    }

    public IProverManager getProverManager() {
        return proverManager;
    }
}
