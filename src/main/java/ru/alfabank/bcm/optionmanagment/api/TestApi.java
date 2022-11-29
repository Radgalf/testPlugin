package ru.alfabank.bcm.optionmanagment.api;

import ru.alfabank.bcm.optionmanagment.dataManagers.ProductManager;
import ru.alfabank.bcm.optionmanagment.model.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/product")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class TestApi {
    private ProductManager productManager;

    public TestApi(ProductManager productManager) {
        this.productManager = productManager;
    }

    @GET
    @Path("/all")
    public Response getProducts() {
        return Response.ok(gson.toJson(productManager.getProducts())).build();
    }

    @PUT
    @Path("/{productId}")
    public Response updateProduct(@PathParam("productId") final int productId,
                                  final Product product) {
        productManager.updateProduct(productId, product);
        return Response.ok().build();
    }

    @POST
    @Path("/")
    public Response saveProduct(final Product product) {
        productManager.createProduct(product);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{productId}")
    public Response deleteProduct(@PathParam("productId") final int productId) {
        productManager.deleteProduct(productId);
        return Response.ok().build();
    }
}
