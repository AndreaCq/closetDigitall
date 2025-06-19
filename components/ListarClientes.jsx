import React, { useEffect, useState } from "react";
import { listarUsuarios } from "../services/clienteService";

const ListarClientes = () => {
  const [clientes, setClientes] = useState([]);

  useEffect(() => {
    listarUsuarios()
      .then((response) => {
        setClientes(response.data);
      })
      .catch((error) => {
        console.error("Error al obtener los clientes:", error);
      });
  }, []);

  return (
    <div>
      <h2 className="mb-3">Lista de Clientes</h2>
      <table className="table table-striped table-bordered">
        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Correo</th>
            <th>Estado</th>
            <th>Fecha Registro</th>
          </tr>
        </thead>
        <tbody>
          {clientes.length > 0 ? (
            clientes.map((cliente) => (
              <tr key={cliente.id_usuario}>
                <td>{cliente.id_usuario}</td>
                <td>{cliente.nombre}</td>
                <td>{cliente.correo}</td>
                <td>{cliente.estado ? "Activo" : "Inactivo"}</td>
                <td>{cliente.fecha_registro}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="5" className="text-center">
                No hay clientes registrados.
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default ListarClientes;
