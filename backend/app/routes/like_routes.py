from flask import Blueprint, jsonify
from flask_jwt_extended import jwt_required, get_jwt_identity
from ..extensions import db
from ..models.like import Like

like_bp = Blueprint("like", __name__, url_prefix="/posts")

@like_bp.route("/<int:post_id>/like", methods=["POST"])
@jwt_required()
def like(post_id):
    user_id = get_jwt_identity()
    db.session.add(Like(user_id=user_id, post_id=post_id))
    db.session.commit()
    return jsonify(message="Liked")
