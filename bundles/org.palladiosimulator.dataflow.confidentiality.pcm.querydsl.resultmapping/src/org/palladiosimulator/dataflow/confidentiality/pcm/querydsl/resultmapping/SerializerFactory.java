package org.palladiosimulator.dataflow.confidentiality.pcm.querydsl.resultmapping;

import org.palladiosimulator.dataflow.confidentiality.transformation.dcp.resultmapping.serialize.ResultMappingSerializer;

public final class SerializerFactory {

    public static ResultMappingSerializer createPlainTextSerializer(boolean serializeFlowTree) {
        return new PlainTextResultMappingSerializer(serializeFlowTree);
    }
    
}
