package org.palladiosimulator.dataflow.confidentiality.pcm.transformation.dcp.workflow.jobs;

import java.util.function.Consumer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.KeyValueMDSDBlackboard;

import de.uka.ipd.sdq.workflow.jobs.AbstractBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;

public class StringConsumerJob<T extends KeyValueMDSDBlackboard> extends AbstractBlackboardInteractingJob<T> {

    public interface ThrowingConsumer<T> {
        void accept(T t) throws Exception;
    }

    private final String blackboardKey;
    private final ThrowingConsumer<String> stringConsumer;

    public StringConsumerJob(String blackboardKey, Consumer<String> stringConsumer) {
        this(blackboardKey, new ThrowingConsumer<String>() {
            @Override
            public void accept(String t) throws Exception {
                stringConsumer.accept(t);
            }
        });
    }

    public StringConsumerJob(String blackboardKey, ThrowingConsumer<String> stringConsumer) {
        this.blackboardKey = blackboardKey;
        this.stringConsumer = stringConsumer;
    }

    @Override
    public void cleanup(IProgressMonitor arg0) throws CleanupFailedException {
        // nothing to do
    }

    @Override
    public void execute(IProgressMonitor arg0) throws JobFailedException, UserCanceledException {
        var stringToConsume = getBlackboard().get(blackboardKey)
            .filter(String.class::isInstance)
            .map(String.class::cast)
            .orElse(null);
        try {
            stringConsumer.accept(stringToConsume);
        } catch (Exception e) {
            throw new JobFailedException("String consumer threw exception.", e);
        }
    }

    @Override
    public String getName() {
        return "String Consumer Job";
    }

}
