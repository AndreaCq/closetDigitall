import axios from "axios";

const API_URL = "http://localhost:8080/api/clientes";



// Crear usuario
export const crearUsuario = (cliente) => {
  return axios.post(`${API_URL}/crear`, cliente);
};

// Listar usuarios
export const listarUsuarios = () => {
  return axios.get(`${API_URL}`);
};

// Actualizar usuario
export const actualizarUsuario = (id, cliente) => {
  return axios.put(`${API_URL}/${id}`, cliente);
};

// Eliminar usuario
export const eliminarUsuario = (id) => {
  return axios.delete(`${API_URL}/${id}`);
  
};

