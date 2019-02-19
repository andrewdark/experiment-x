package ua.pp.darknsoft.services.tests;

import ua.pp.darknsoft.dto.TestTO;

import java.util.Collection;

public interface TestsService {
    Collection<TestTO> getTests(Long taskId);
}
