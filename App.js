import React from "react";
import ClienteForm from "./components/ClienteForm";
import EliminarCliente from "./components/EliminarCliente";
import ActualizarCliente from "./components/ActualizarCliente";
import ListarClientes from "./components/ListarClientes";
import Navbar from "./components/Navbar";

function App() {
  return (
    <>
      <Navbar />
      <div className="container my-5">
        <h1 className="text-center mb-4">Closet Digital 👗</h1>

        <div className="row">
          <div className="col-md-6 mb-4">
            <div className="card">
              <div className="card-header bg-primary text-white">Registrar Cliente</div>
              <div className="card-body">
                <ClienteForm />
              </div>
            </div>
          </div>

          <div className="col-md-6 mb-4">
            <div className="card">
              <div className="card-header bg-warning text-white">Actualizar Cliente</div>
              <div className="card-body">
                <ActualizarCliente />
              </div>
            </div>
          </div>

          <div className="col-md-6 mb-4">
            <div className="card">
              <div className="card-header bg-danger text-white">Eliminar Cliente</div>
              <div className="card-body">
                <EliminarCliente />
              </div>
            </div>
          </div>

          <div className="col-12">
            <div className="card">
              <div className="card-header bg-info text-white">Lista de Clientes</div>
              <div className="card-body">
                <ListarClientes />
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default App;




