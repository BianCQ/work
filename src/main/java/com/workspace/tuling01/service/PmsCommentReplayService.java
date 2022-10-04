package com.workspace.tuling01.service;

public interface PmsCommentReplayService extends IService<PmsCommentReplay> {
    ProductUpdateInitDTO getUpdateInfo(Long id);
}
