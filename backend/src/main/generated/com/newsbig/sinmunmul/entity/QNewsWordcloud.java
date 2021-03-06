package com.newsbig.sinmunmul.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNewsWordcloud is a Querydsl query type for NewsWordcloud
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QNewsWordcloud extends EntityPathBase<NewsWordcloud> {

    private static final long serialVersionUID = -296136557L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNewsWordcloud newsWordcloud = new QNewsWordcloud("newsWordcloud");

    public final QCommonCodeGroup commonCodeGroup;

    public final StringPath delYn = createString("delYn");

    public final StringPath modDt = createString("modDt");

    public final StringPath modId = createString("modId");

    public final StringPath regDt = createString("regDt");

    public final StringPath regId = createString("regId");

    public final StringPath wordcloud = createString("wordcloud");

    public final NumberPath<Long> wordcloudSeq = createNumber("wordcloudSeq", Long.class);

    public QNewsWordcloud(String variable) {
        this(NewsWordcloud.class, forVariable(variable), INITS);
    }

    public QNewsWordcloud(Path<? extends NewsWordcloud> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNewsWordcloud(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNewsWordcloud(PathMetadata metadata, PathInits inits) {
        this(NewsWordcloud.class, metadata, inits);
    }

    public QNewsWordcloud(Class<? extends NewsWordcloud> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commonCodeGroup = inits.isInitialized("commonCodeGroup") ? new QCommonCodeGroup(forProperty("commonCodeGroup")) : null;
    }

}

