package ru.alfabank.bcm.optionmanagment.dataManagers;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.common.base.Preconditions.checkNotNull;

public final class TodoServlet extends HttpServlet {
    @ComponentImport
    private final ActiveObjects ao;

    @Inject
    public TodoServlet(ActiveObjects ao) {
        this.ao = checkNotNull(ao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().write("Todo servlet, doGet");
        res.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().write("Todo servlet, doPost");
        res.getWriter().close();
    }
}
