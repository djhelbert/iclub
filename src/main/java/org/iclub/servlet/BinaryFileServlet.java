package org.iclub.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclub.model.BinaryFile;
import org.iclub.service.BinaryFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinaryFileServlet extends HttpServlet {

	private BinaryFileService binaryFileService;

	private static final long serialVersionUID = -8674792365261419577L;
	private static final Logger LOGGER = LoggerFactory.getLogger(BinaryFileServlet.class);

	@Autowired
	public BinaryFileServlet(BinaryFileService binaryFileService) {
		super();
		this.binaryFileService = binaryFileService;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		final String id = req.getParameter("id");
        final Long idParameter = new Long(id);

		BinaryFile binaryFile = binaryFileService.getBinaryFile(idParameter);
		resp.setContentType(binaryFile.getMimetype());

		final ByteArrayInputStream is = new ByteArrayInputStream(binaryFile.getData());
		OutputStream out = null;

		try {
			out = resp.getOutputStream();
			byte[] buf = new byte[binaryFile.getData().length];
		    int count = 0;

			while ((count = is.read(buf)) >= 0) {
			     out.write(buf, 0, count);
			}
		} catch (IOException e) {
			LOGGER.error("BinaryFileServlet.doGet()", e);
		}

	    try {
	    	if (out != null) {
			  out.close();
	    	}
		} catch (IOException e) {
			LOGGER.error("BinaryFileServlet.doGet()", e);
		}
	}
	
}
