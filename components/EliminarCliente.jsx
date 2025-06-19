import React, { useState } from "react";
import { eliminarUsuario } from "../services/clienteService";

const EliminarCliente = () => {
  const [id, setId] = useState("");

  const handleChange = (e) => {
    setId(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!id) {
      alert("Por favor, ingresa un ID válido.");
      return;
    }

    eliminarUsuario(id)
      .then(() => {
        alert(`Usuario con ID ${id} eliminado correctamente.`);
        setId(""); // Limpia el campo
      })
      .catch((error) => {
        alert("Error al eliminar el usuario.");
        console.error(error);
      });
  };

  return (
    <div>
      <h2>Eliminar Cliente</h2>
      <form onSubmit={handleSubmit}>
        <label>ID del Cliente:</label>
        <input
          type="number"
          value={id}
          onChange={handleChange}
          required
          placeholder="Ingresa el ID del cliente"
        />
        <br />
        <button type="submit">Eliminar</button>
      </form>
    </div>
  );
};

export default EliminarCliente;
