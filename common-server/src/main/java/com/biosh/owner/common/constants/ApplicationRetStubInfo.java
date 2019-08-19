package com.biosh.owner.common.constants;

/**
 * @description
 * @date 2019/8/5
 */
public class ApplicationRetStubInfo extends RuntimeException{

    private RetStub RetStub;

    public ApplicationRetStubInfo(RetStubDetailInfo retStubDetailInfo) {
        this.RetStub = retStubDetailInfo;
    }

    public RetStub getRetStubDetailInfo() {
        return RetStub;
    }

    @Override
    public String getMessage() {
        return "code:" + RetStub.getCode() + " message:" + RetStub.getMessage();
    }
}
