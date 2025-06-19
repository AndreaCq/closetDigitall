import React, { useState } from "react";
import { actualizarUsuario } from "../services/clienteService";

const ActualizarCliente = () => {
  const [cliente, setCliente] = useState({
    id: "",
    nombre: "",
    correo: "",
    password: "",
    estado: true
  });

  const handleChange = (e) => {
    setCliente({ ...cliente, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!cliente.id) {
      alert("Por favor, ingresa un ID válido.");
      return;
    }

    actualizarUsuario(cliente.id, {
      nombre: cliente.nombre,
      correo: cliente.correo,
      password: cliente.password,
      estado: cliente.estado
    })
      .then(() => {
        alert("Usuario actualizado correctamente");
      })
      .catch((error) => {
        alert("Error al actualizar usuario");
        console.error(error);
      });
  };

  return (
    <div>
      <h2>Actualizar Cliente</h2>
      <form onSubmit={handleSubmit}>
        <label>ID:</label>
        <input
          type="number"
          name="id"
          value={cliente.id}
          onChange={handleChange}
          className="form-control mb-2"
          required
        />

        <label>Nombre:</label>
        <input
          type="text"
          name="nombre"
          value={cliente.nombre}
          onChange={handleChange}
          className="form-control mb-2"
          required
        />

        <label>Correo:</label>
        <input
          type="email"
          name="correo"
          value={cliente.correo}
          onChange={handleChange}
          className="form-control mb-2"
          required
        />

        <label>Contraseña:</label>
        <input
          type="password"
          name="password"
          value={cliente.password}
          onChange={handleChange}
          className="form-control mb-2"
          required
        />

        <label>Estado:</label>
        <select
          name="estado"
          value={cliente.estado}
          onChange={(e) =>
            setCliente({ ...cliente, estado: e.target.value === "true" })
          }
          className="form-control mb-3"
        >
          <option value="true">Activo</option>
          <option value="false">Inactivo</option>
        </select>

        <button type="submit" className="btn btn-warning">
          Actualizar
        </button>
      </form>
    </div>
  );
};

export default ActualizarCliente;

