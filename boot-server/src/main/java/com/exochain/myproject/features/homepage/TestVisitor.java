package com.exochain.myproject.features.homepage;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.time.ZonedDateTime;

public class TestVisitor {
    private String testId;
    private ZonedDateTime sessionStart;

    public TestVisitor(String testId, ZonedDateTime sessionStart) {
        this.testId = testId;
        this.sessionStart = sessionStart;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public ZonedDateTime getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(ZonedDateTime sessionStart) {
        this.sessionStart = sessionStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestVisitor that = (TestVisitor) o;
        return Objects.equal(testId, that.testId) &&
                Objects.equal(sessionStart, that.sessionStart);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(testId, sessionStart);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("testId", testId)
                .add("sessionStart", sessionStart)
                .toString();
    }
}
