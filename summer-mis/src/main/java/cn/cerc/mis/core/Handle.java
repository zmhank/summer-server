package cn.cerc.mis.core;

import cn.cerc.core.ISession;
import cn.cerc.db.core.IHandle;

public class Handle implements IHandle{

    protected IHandle handle;
    private ISession session;
    
    public Handle() {

    }
    
    public Handle(ISession session) {
        this.session = session;
    }

    public Handle(ISession session, String corpNo, String userCode) {
        this(session);
        setCorpNo(corpNo);
        setUserCode(userCode);
    }

    private void setCorpNo(String corpNo) {
        session.setProperty(Application.bookNo, corpNo);
    }

    private void setUserCode(String userCode) {
        session.setProperty(Application.userCode, userCode);
    }

    @Override
    public ISession getSession() {
        return session;
    }

    @Override
    public void setSession(ISession session) {
        this.session = session;
    }

    public void setHandle(IHandle handle) {
        this.handle = handle;
        if (handle != null) {
            this.setSession(handle.getSession());
        }
    }

    public IHandle getHandle() {
        return this.handle;
    }

}
